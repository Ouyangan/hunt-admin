package com.hunt.controller;

import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysUser;
import com.hunt.service.SysUserService;
import com.hunt.service.SystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.ResponseCode;
import system.Result;
import system.StringUtil;

import java.util.UUID;

/**
 * @Author ouyangan
 * @Date 2016/10/8/13:37
 * @Description
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "toUser", method = RequestMethod.GET)
    public String toUser() {
        return "system/user";
    }

    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Result insert(@RequestParam String loginName,
                         @RequestParam String zhName,
                         @RequestParam(defaultValue = "") String enName,
                         @RequestParam int sex,
                         @RequestParam(defaultValue = "") String birth,
                         @RequestParam(defaultValue = "") String email,
                         @RequestParam(defaultValue = "") String phone,
                         @RequestParam(defaultValue = "") String address,
                         @RequestParam String password,
                         @RequestParam(defaultValue = "1") int isFinal,
                         @RequestParam String jobIds,
                         @RequestParam String permissionIds) {
        boolean isExistLoginName = sysUserService.isExistLoginName(loginName);
        if (isExistLoginName) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        if ((!StringUtils.hasText(password)) && password.length() < 6) {
            return Result.error("请设置密码长度大于等于6");
        }
        SysUser user = new SysUser();
        user.setLoginName(loginName);
        user.setZhName(zhName);
        user.setEnName(enName);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setBirth(birth);
        user.setIsFinal(isFinal);
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        user.setPasswordSalt(salt);
        user.setPassword(StringUtil.createPassword(password, salt, 2));
        long id = sysUserService.insertUser(user, jobIds, permissionIds);
        return Result.success(id);
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Result delete(@RequestParam long id) {
        SysUser user = sysUserService.selectById(id);
        if (user == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (user.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        sysUserService.deleteById(id);
        systemService.forceLogout(id);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestParam long id,
                         @RequestParam String loginName,
                         @RequestParam String zhName,
                         @RequestParam String enName,
                         @RequestParam int sex,
                         @RequestParam(defaultValue = "") String birth,
                         @RequestParam(defaultValue = "") String email,
                         @RequestParam(defaultValue = "") String phone,
                         @RequestParam(defaultValue = "") String address,
                         @RequestParam String jobIds,
                         @RequestParam String permissionIds) {
        boolean isExistLoginNameExlcudeId = sysUserService.isExistLoginNameExcludeId(id, loginName);
        if (isExistLoginNameExlcudeId) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        SysUser user = sysUserService.selectById(id);
        if (user.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        user.setLoginName(loginName);
        user.setZhName(zhName);
        user.setEnName(enName);
        user.setSex(sex);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setBirth(birth);
        sysUserService.updateUser(user, jobIds, permissionIds);
        systemService.clearAuthorizationInfoCacheByUserId(id);
        return Result.success();
    }

    @RequiresPermissions("user:select")
    @ResponseBody
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public PageInfo select(@RequestParam int page,
                           @RequestParam int rows,
                           @RequestParam(defaultValue = "zhName") String sort,
                           @RequestParam(defaultValue = "asc") String order,
                           @RequestParam(defaultValue = "") String loginName,
                           @RequestParam(defaultValue = "") String zhName,
                           @RequestParam(defaultValue = "") String email,
                           @RequestParam(defaultValue = "") String phone,
                           @RequestParam(defaultValue = "") String address) {
        PageInfo pageInfo = sysUserService.selectPage(page, rows, StringUtil.camelToUnderline(sort), order,loginName,zhName,email,phone,address);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public Result updatePassword(@RequestParam long id,
                                 @RequestParam String oldPassword,
                                 @RequestParam String newPassword) {
        SysUser user = sysUserService.selectById(id);
        if (!oldPassword.equals(StringUtil.createPassword(oldPassword, user.getPasswordSalt(), 2))) {
            return Result.error("原密码错误");
        }
        if ((!StringUtils.hasText(newPassword)) && newPassword.length() < 6) {
            return Result.error("请设置密码长度大于等于6");
        }
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        user.setPasswordSalt(salt);
        user.setPassword(StringUtil.createPassword(newPassword, salt, 2));
        sysUserService.updateUser(user);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "forbiddenUser", method = RequestMethod.GET)
    public Result forbiddenUser(@RequestParam long id) {
        SysUser sysUser = sysUserService.selectById(id);
        if (sysUser.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        sysUser.setStatus(3);
        sysUserService.updateUser(sysUser);
        systemService.forceLogout(sysUser.getId());
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "enableUser", method = RequestMethod.GET)
    public Result enableUser(@RequestParam long id) {
        SysUser sysUser = sysUserService.selectById(id);
        if (sysUser.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        sysUser.setStatus(1);
        sysUserService.updateUser(sysUser);
        systemService.clearAuthorizationInfoCacheByUserId(sysUser.getId());
        return Result.success();
    }

}

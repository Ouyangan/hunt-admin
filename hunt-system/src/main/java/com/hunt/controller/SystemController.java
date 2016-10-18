package com.hunt.controller;

import com.hunt.model.dto.LoginInfo;
import com.hunt.model.entity.SysUser;
import com.hunt.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.ResponseCode;
import system.Result;

/**
 * @Author: ouyangan
 * @Date : 2016/10/17
 */
@Controller
@RequestMapping("system")
public class SystemController {

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toIndex() {
        return "system/index";
    }

    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @param platform
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestParam String loginName,
                        @RequestParam String password,
                        @RequestParam int platform) {

        SysUser user = sysUserService.selectByLoginName(loginName);
        if (user == null) {
            return Result.instance(ResponseCode.unknown_account.getCode(), ResponseCode.unknown_account.getMsg());
        }
        if (user.getStatus() == 3) {
            return Result.instance(ResponseCode.forbidden_account.getCode(), ResponseCode.forbidden_account.getMsg());
        }
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(loginName, password));
        LoginInfo loginInfo = sysUserService.login(user, subject.getSession().getId(), platform);
        subject.getSession().setAttribute("loginInfo", loginInfo);
        return Result.success(loginInfo);
    }

    /**
     * 退出
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success();
    }

    /**
     * 强制用户下线
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "forceLogout", method = RequestMethod.GET)
    public Result forceLogout(@RequestParam long userId) {
        sysUserService.forceLogout(userId);
        return Result.success();
    }

}

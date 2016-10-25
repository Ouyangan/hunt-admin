package com.hunt.controller;

import com.hunt.model.dto.LoginInfo;
import com.hunt.model.dto.PageInfo;
import com.hunt.model.entity.SysDataGroup;
import com.hunt.model.entity.SysDataItem;
import com.hunt.model.entity.SysUser;
import com.hunt.service.SysUserService;
import com.hunt.service.SystemService;
import com.hunt.system.security.geetest.GeetestConfig;
import com.hunt.system.security.geetest.GeetestLib;
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
import system.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/10/17
 */
@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SystemService systemService;


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
                        @RequestParam int platform,
                        HttpServletRequest request) throws Exception {
        if (!verifyCaptcha(request)) {
            return Result.instance(ResponseCode.verify_captcha_error.getCode(), ResponseCode.verify_captcha_error.getMsg());
        }
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

    @ResponseBody
    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public String StartCaptcha(HttpServletRequest request) {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());
        int gtServerStatus = gtSdk.preProcess();
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        return gtSdk.getResponseStr();
    }

    @RequestMapping(value = "toOnline", method = RequestMethod.GET)
    public String toOnline() {
        return "system/online";
    }

    @ResponseBody
    @RequestMapping(value = "online", method = RequestMethod.GET)
    public PageInfo online(@RequestParam int page,
                           @RequestParam int rows) {
        PageInfo pageInfo = systemService.selectLogStatus(page, rows);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "forceLogout", method = RequestMethod.GET)
    public Result forceLogout(@RequestParam String userIds) {
        System.out.println("userIds = [" + userIds + "]");
        String[] ids = userIds.split(",");
        for (String id : ids) {
            systemService.forceLogout(Long.parseLong(id));
        }
        return Result.success();
    }


    @RequestMapping(value = "toLog")
    public String toLog() {
        return "system/log";
    }


    @ResponseBody
    @RequestMapping(value = "log/select", method = RequestMethod.GET)
    public PageInfo log(@RequestParam int page,
                        @RequestParam int rows,
                        @RequestParam(defaultValue = "id") String sort,
                        @RequestParam(defaultValue = "desc") String order,
                        @RequestParam(defaultValue = "") String method,
                        @RequestParam(defaultValue = "") String url,
                        @RequestParam(defaultValue = "") String param,
                        @RequestParam(defaultValue = "") String result) {
        System.out.println("page = [" + page + "], rows = [" + rows + "], sort = [" + sort + "], order = [" + order + "], method = [" + method + "], url = [" + url + "], param = [" + param + "], result = [" + result + "]");
        PageInfo pageInfo = systemService.selectLog(page, rows, StringUtil.camelToUnderline(sort), order, method, url, param, result);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "dataGroup/insert", method = RequestMethod.POST)
    public Result dataGroupInsert(@RequestParam String name,
                                  @RequestParam String description) {
        boolean isExistName = systemService.isExistDataGroupName(name);
        if (isExistName) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        SysDataGroup sysDataGroup = new SysDataGroup();
        sysDataGroup.setName(name);
        sysDataGroup.setDescription(description);
        sysDataGroup.setParentId(0L);
        sysDataGroup.setIsFinal(2);
        Long id = systemService.insertSysDataGroup(sysDataGroup);
        return Result.success(id);
    }

    @ResponseBody
    @RequestMapping(value = "dataGroup/list", method = RequestMethod.GET)
    public List<SysDataGroup> dataGroupList() {
        List<SysDataGroup> list = systemService.selectDataGroupList();
        return list;
    }

    @RequestMapping(value = "toData", method = RequestMethod.GET)
    public String toData() {
        return "system/data";
    }

    @ResponseBody
    @RequestMapping(value = "data/insert", method = RequestMethod.POST)
    public Result dataInsert(@RequestParam String key,
                             @RequestParam String value,
                             @RequestParam String description,
                             @RequestParam long groupId) {
        boolean isExistName = systemService.isExistDataItemKeyName(key, groupId);
        if (isExistName) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        SysDataItem sysDataItem = new SysDataItem();
        sysDataItem.setKeyName(key);
        sysDataItem.setKeyValue(value);
        sysDataItem.setSysDataGroupId(groupId);
        sysDataItem.setDescription(description);
        long id = systemService.insertSysDataItem(sysDataItem);
        return Result.success(id);
    }

    @ResponseBody
    @RequestMapping(value = "data/delete", method = RequestMethod.GET)
    public Result dataDelete(@RequestParam Long id) {
        systemService.deleteDataItemById(id);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "data/update", method = RequestMethod.POST)
    public Result dataUpdate(@RequestParam Long id,
                             @RequestParam String key,
                             @RequestParam String value,
                             @RequestParam String description,
                             @RequestParam long groupId) {
        SysDataItem sysDataItem = systemService.selectDataItemById(id);
        if (sysDataItem == null) {
            return Result.error(ResponseCode.data_not_exist.getMsg());
        }
        if (sysDataItem.getIsFinal() == 2) {
            return Result.error(ResponseCode.can_not_edit.getMsg());
        }
        boolean isExistDataItemNameExcludeId = systemService.isExistDataItemNameExcludeId(id, key, groupId);
        if (isExistDataItemNameExcludeId) {
            return Result.error(ResponseCode.name_already_exist.getMsg());
        }
        sysDataItem.setKeyName(key);
        sysDataItem.setKeyValue(value);
        sysDataItem.setSysDataGroupId(groupId);
        sysDataItem.setDescription(description);
        systemService.updateDateItem(sysDataItem);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "data/select", method = RequestMethod.GET)
    public Result dataSelect() {
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "data/list", method = RequestMethod.GET)
    public PageInfo dataList(@RequestParam int page,
                             @RequestParam int rows) {
        PageInfo pageInfo = systemService.selectDataItemPage(page, rows);
        return pageInfo;
    }

}

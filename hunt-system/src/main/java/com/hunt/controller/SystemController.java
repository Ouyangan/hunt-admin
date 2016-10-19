package com.hunt.controller;

import com.hunt.model.dto.LoginInfo;
import com.hunt.model.entity.SysUser;
import com.hunt.service.SysUserService;
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

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

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

    @ResponseBody
    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public String StartCaptcha(HttpServletRequest request) {

        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());

        String resStr = "{}";

        //自定义userid
        String userid = "test";

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(userid);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);

        return gtSdk.getResponseStr();
    }

    @ResponseBody
    @RequestMapping(value = "captcha", method = RequestMethod.POST)
    public Result verifyCaptcha(HttpServletRequest request) {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());

        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);

        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

        //从session中获取userid
        String userid = (String) request.getSession().getAttribute("userid");

        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证

            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, userid);
        } else {
            // gt-server非正常情况下，进行failback模式验证
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
        }

        if (gtResult != 1) {
            return Result.error();
        }
        return Result.success();
    }
}

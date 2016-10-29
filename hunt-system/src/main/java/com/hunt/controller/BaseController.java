package com.hunt.controller;

import com.hunt.service.SystemService;
import com.hunt.system.exception.ForbiddenIpException;
import com.hunt.system.security.geetest.GeetestConfig;
import com.hunt.system.security.geetest.GeetestLib;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import system.ResponseCode;
import system.Result;
import system.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础controller,方便统一异常处理
 *
 * @Author: ouyangan
 * @Date : 2016/10/8
 */
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private SystemService systemService;

    /**
     * 极限验证码二次验证
     *
     * @param request
     * @return
     * @throws Exception
     */
    public boolean verifyCaptcha(HttpServletRequest request) throws Exception {
        log.debug("begin verifyCaptcha");
        int verifyResult = 0;
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key());
        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
        log.debug("challenge: {} ,validate: {} ,seccode: {}", challenge, validate, seccode);
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
        log.debug("gt_server_status_code : {}", gt_server_status_code);
        if (gt_server_status_code == 1) {
            verifyResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode);
        } else {
            verifyResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
        }
        log.debug("verifyResult : {}", verifyResult);
        return verifyResult == 1;
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        if (request.getHeader("Accept").contains("application/json")) {

        } else {

        }
        log.error("exception occur : \n {}", StringUtil.exceptionDetail(exception));
        Result result = Result.error();
        //密码错误
        if (exception instanceof IncorrectCredentialsException) {
            result = Result.instance(ResponseCode.password_incorrect.getCode(), ResponseCode.password_incorrect.getMsg());
            //账号不存在
        } else if (exception instanceof UnknownAccountException) {
            result = Result.instance(ResponseCode.unknown_account.getCode(), ResponseCode.unknown_account.getMsg());
            //未授权
        } else if (exception instanceof UnauthorizedException) {
            result = Result.instance(ResponseCode.unauthorized.getCode(), ResponseCode.unauthorized.getMsg());
            //未登录
        } else if (exception instanceof UnauthenticatedException) {
            result = Result.instance(ResponseCode.unauthenticated.getCode(), ResponseCode.unauthenticated.getMsg());
            //缺少参数
        } else if (exception instanceof MissingServletRequestParameterException) {
            result = Result.instance(ResponseCode.missing_parameter.getCode(), ResponseCode.missing_parameter.getMsg());
            //参数格式错误
        } else if ((exception instanceof MethodArgumentTypeMismatchException)) {
            result = Result.instance(ResponseCode.param_format_error.getCode(), ResponseCode.param_format_error.getMsg());
            //ip限制
        } else if (exception.getCause().getMessage().contains("com.hunt.system.exception.ForbiddenIpException")) {
            result = Result.instance(ResponseCode.forbidden_ip.getCode(), ResponseCode.forbidden_ip.getMsg());
            //其他错误
        } else {
            result = Result.instance(ResponseCode.error.getCode(), ResponseCode.error.getMsg());
        }
        result.setData(StringUtil.exceptionDetail(exception));
        return result;
    }
}

package com.hunt.controller;

import com.google.gson.Gson;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.UnknownSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import system.ResponseCode;
import system.Result;
import system.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ouyangan
 * @Date : 2016/10/8
 */
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, Exception exception) {
        log.debug("exception occur : \n {}", StringUtil.exceptionDetail(exception));
        Result result;
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
            //其他错误
        } else {
            result = Result.instance(ResponseCode.error.getCode(), ResponseCode.error.getMsg());
        }
        result.setData(StringUtil.exceptionDetail(exception));
        return result;
    }
}

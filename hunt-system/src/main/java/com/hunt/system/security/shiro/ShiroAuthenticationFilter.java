package com.hunt.system.security.shiro;

import com.google.gson.Gson;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system.ResponseCode;
import system.Result;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ouyangan
 * @Date 2016/11/1/19:32
 * @Description 登录过滤器
 */
public class ShiroAuthenticationFilter extends PassThruAuthenticationFilter {
    private static Logger log = LoggerFactory.getLogger(ShiroAuthorizationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            log.debug("登录认证:通过");
            return true;
        } else {
            saveRequest(request);
            if (((HttpServletRequest)request).getHeader("Accept").contains("application/json")) {
                log.debug("登录认证:未通过:json");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                Result result = new Result(ResponseCode.unauthenticated.getCode(), ResponseCode.unauthenticated.getMsg());
                response.getWriter().append(new Gson().toJson(result));
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                log.debug("登录认证:未通过:web");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                ((HttpServletResponse) response).sendRedirect("/");
            }
            return false;
        }
    }
}

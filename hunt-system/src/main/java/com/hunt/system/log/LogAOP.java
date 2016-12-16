package com.hunt.system.log;

import com.hunt.model.entity.SysLog;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.hunt.service.SystemService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ouyangan
 * @Date : 2016/10/15
 */
@Aspect
@Component
@Order(2)
public class LogAOP {
    private static final Logger logger = LoggerFactory.getLogger(LogAOP.class);

    @Autowired
    private SystemService systemService;

    @Around("@within(org.springframework.web.bind.annotation.RequestMapping)")
    public Object recordLog(ProceedingJoinPoint p) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Object o = null;
        long t1 = System.currentTimeMillis();
        try {
            o = p.proceed();
        } catch (Exception e) {//这里建议将异常向上层抛让异常处理器来进行捕捉
            if (e instanceof UnknownAccountException) {
                throw new UnknownAccountException(e);
            } else if (e instanceof IncorrectCredentialsException) {
                throw new IncorrectCredentialsException(e);
            } else if (e instanceof UnauthorizedException) {
                throw new UnauthorizedException(e);
            } else {
                throw new Exception(e);
            }
        }
        SysLog log = new SysLog();

        long t2 = System.currentTimeMillis();

        if (o.toString().length() < 5000) {
            log.setResult(o.toString());
        } else {
            log.setResult("data is too long");
        }
        log.setDuration((t2 - t1));
        log.setMethod(p.getTarget().getClass().getName() + "." + p.getSignature().getName());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : request.getParameterMap().keySet()) {
            stringBuilder.append(s);
            stringBuilder.append(" = ");
            stringBuilder.append(request.getParameterMap().get(s)[0]);
            stringBuilder.append(" | ");
        }
        log.setParam(stringBuilder.toString());
        log.setIp(request.getRemoteAddr());
        log.setUrl(request.getRequestURL().toString());
        log.setUserAgent(request.getHeader("user-agent"));
        systemService.insertSysControllerLog(log);

        logger.info("request contentType:{}", request.getHeader("Accept"));
        logger.info("request param : {}", log.getParam());
        logger.info("reuest method : {}", request.getMethod());
        logger.info("request url : {}", log.getUrl());
        return o;
    }

}

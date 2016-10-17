package com.hunt.system.log;

import com.hunt.model.entity.SysLog;
import com.hunt.service.SysLogService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import system.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ouyangan
 * @Date : 2016/10/15
 */
@Aspect
@Component
public class ControllerLog {
    private static final Logger logger = LoggerFactory.getLogger(ControllerLog.class);

    @Autowired
    private SysLogService sysLogService;

    @Around("@within(org.springframework.web.bind.annotation.RequestMapping)")
    public Object recordLog(ProceedingJoinPoint p) throws Throwable {
        HttpServletRequest re = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Object o = null;
        long t1 = System.currentTimeMillis();
        try {
            o = p.proceed();
        } catch (Exception e) {//这里建议将异常向上层抛让异常处理器来进行捕捉,方便定义响应消息
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

        log.setResult(o.toString());
        log.setDuration((t2 - t1));
        log.setMethod(p.getTarget().getClass().getName() + "." + p.getSignature().getName());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : re.getParameterMap().keySet()) {
            stringBuilder.append(s);
            stringBuilder.append(" = ");
            stringBuilder.append(re.getParameterMap().get(s)[0]);
            stringBuilder.append(" | ");
        }
        log.setParam(stringBuilder.toString());
        log.setIp(re.getRemoteAddr());
        log.setUrl(re.getRequestURL().toString());
        sysLogService.insertSysControllerLog(log);

        logger.info("request param : {}", log.getParam());
        logger.info("reuest method : {}", re.getMethod());
        logger.info("request url : {}", log.getUrl());
        logger.info("request result: {}", StringUtil.formatJson(log.getResult()));
        return o;
    }

}

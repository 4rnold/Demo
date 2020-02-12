package com.arnold.febs.common.aop;

import com.arnold.febs.common.entity.FebsResponse;
import com.arnold.febs.common.exception.FebsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(public com.arnold.febs.common.entity.FebsResponse com.arnold.febs.system.controller.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        FebsResponse response = null;

        try {
            response = (FebsResponse) pjp.proceed();

            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("[{}]use time:{}",pjp.getSignature(), elapsedTime);
        } catch (Throwable throwable) {
            response = handlerException(pjp, throwable);
        }
        return response;
    }

    private FebsResponse handlerException(ProceedingJoinPoint pjp, Throwable e) {
        log.debug("exception",e);
        FebsResponse response = new FebsResponse();

        //认证错误
        if (e instanceof FebsException) {
            return new FebsResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage());
        } else if (e instanceof IncorrectCredentialsException) {
            return new FebsResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message("密码错误");
        } else if (e instanceof AuthenticationException) {
            return new FebsResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage());
        } else if (e instanceof AuthorizationException) {
            return new FebsResponse().code(HttpStatus.UNAUTHORIZED).message(e.getMessage());
        } else {
            return new FebsResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message("系统内部有错误");
        }
    }

/*    public static void main(String[] args) {
        IncorrectCredentialsException incorrectCredentialsException = new IncorrectCredentialsException();
        boolean b = incorrectCredentialsException instanceof AuthenticationException;
        System.out.println(b);
    }*/

}

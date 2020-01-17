package com.example.springbootdemo.spring.T6_ControllerAop.aop;

import com.example.springbootdemo.spring.T6_ControllerAop.beans.ResultBean;
import com.example.springbootdemo.spring.T6_ControllerAop.exceptions.CheckException;
import com.example.springbootdemo.spring.T6_ControllerAop.exceptions.UnloginException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.naming.NoPermissionException;

@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(public * com.example.springbootdemo.spring.T6_ControllerAop.controller.*.*(..))")
    private void controllerAspect() {
    }


    @Around(value = "controllerAspect()")
    public Object methodBefore(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("[{}]use time: {}", joinPoint.getSignature(), elapsedTime);
        } catch (Throwable throwable) {
            result = handleException(joinPoint, throwable);
        }
        return result;

    }

    private ResultBean<?> handleException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常【注意：已知异常不要打印堆栈，否则会干扰日志】
        // 校验出错，参数非法
        if (e instanceof CheckException || e instanceof IllegalArgumentException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.CHECK_FAIL);
        }
        // 没有登陆
        else if (e instanceof UnloginException) {
            result.setMsg("Unlogin");
            result.setCode(ResultBean.NO_LOGIN);
        }
        // 没有权限
        else if (e instanceof NoPermissionException) {
            result.setMsg("NO PERMISSION");
            result.setCode(ResultBean.NO_PERMISSION);
        } else {
            log.error(pjp.getSignature() + " error ", e);

            // TODO 未知的异常，应该格外注意，可以发送邮件通知等
            result.setMsg(e.toString());
            result.setCode(ResultBean.UNKNOWN_EXCEPTION);
        }

        return result;
    }

}

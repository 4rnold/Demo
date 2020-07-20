package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.config;

import com.example.springbootdemo.spring.T6_ControllerAop.beans.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAOP {

//    @Pointcut("execution(* org.springframework.web.servlet.HandlerAdapter.handle(..))")
//    private void handlerAspect() {
//    }

//    @Pointcut("execution(* com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller.TestPropertyEditorController.test(..))")
//    private void handlerAspect() {
//    }

    @Pointcut("execution(* org.springframework.web.servlet.HandlerMapping.getHandler(..))")
    private void handlerAspect() {
    }

    @Around(value = "handlerAspect()")
    public Object methodBefore(ProceedingJoinPoint joinPoint) throws Throwable {
//        Signature signature = joinPoint.getSignature();
        System.out.println(joinPoint.getTarget().getClass());
        return joinPoint.proceed();
    }

}

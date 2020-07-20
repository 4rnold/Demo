package com.example.springbootdemo.best_practice.aspect;

import com.example.springbootdemo.best_practice.api.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * HibernateValidator错误结果处理切面
 * Created by macro on 2018/4/26.
 */
@Aspect
@Component
@Order(2)
public class BindingResultAspect {
    @Pointcut("execution(public * com.macro.mall.controller.*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    fieldError.contains(TypeMismatchException.class);
// * (typically {@link org.springframework.beans.PropertyAccessException})  类型转换失败
//	 * or a Bean Validation {@link javax.validation.ConstraintViolation}.   参数验证失败
//有这么处理的例子：
//https://github.com/yanbo-liang/hive/blob/c7874814086fd7598dd7a82b421aba25ea7d687a/hive-web/src/main/java/cc/cc3c/hive/web/controller/advice/HiveControllerAdvice.java)
                    if(fieldError!=null){
                        return CommonResult.validateFailed(fieldError.getDefaultMessage());
                    }else{
                        return CommonResult.validateFailed();
                    }
                }
            }
        }


        return joinPoint.proceed();
    }
}
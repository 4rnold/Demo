package com.example.springbootdemo.spring.ControllerAdvice.advice;

import com.example.springbootdemo.spring.ControllerAdvice.exception.CouponException;
import com.example.springbootdemo.spring.ControllerAdvice.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @AUTHOR zhangxf
 * @CREATE 2020-02-11 11:27
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 对CouponException进行统一处理
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(CouponException.class)
    public CommonResponse<String> handlerCouponException(HttpServletRequest request, CouponException exception) {

        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(exception.getMessage());
        return response;
    }
}
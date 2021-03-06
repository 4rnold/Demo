package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    //校验@Validated失败
    /*
    @Validated注解在controller上
    @min 注解在参数上

    json中@min限制
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<String> handle(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append(violation.getInvalidValue() + " " + violation.getMessage() + "\n");
        }
        String result = strBuilder.toString();
        return new ResponseEntity<String>("ConstraintViolation:" + result, HttpStatus.BAD_REQUEST);
    }

    //没有加BindingResult会抛出BindException
    //bindingResult包装
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
                                                         WebRequest request) {
        return new ResponseEntity<Object>("BindException:" + buildMessages(ex.getBindingResult()),
                HttpStatus.BAD_REQUEST);
    }

    //json格式验证失败，包括@JsonFormat
    //这个是httpMessageConverter类型转换时抛出
    // 这个异常BindingResult捕获不了
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("HttpMessageNotReadableException:" + ex.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    //json验证valid失败@min
    //验证时抛出
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("MethodArgumentNotValid:" + buildMessages(ex.getBindingResult()),
                HttpStatus.BAD_REQUEST);
    }

    //缺少参数@RequestParam(required = true)
    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                       HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("ParamMissing:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //类型转换失败比如 string转int
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
                                                        HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("TypeMissMatch:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private String buildMessages(BindingResult result) {
        StringBuilder resultBuilder = new StringBuilder();

        List<ObjectError> errors = result.getAllErrors();
        if (errors != null && errors.size() > 0) {
            for (ObjectError error : errors) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError) error;
                    String fieldName = fieldError.getField();
                    String fieldErrMsg = fieldError.getDefaultMessage();
                    resultBuilder.append(fieldName).append(" ").append(fieldErrMsg).append(";");
                }
            }
        }
        return resultBuilder.toString();
    }
}
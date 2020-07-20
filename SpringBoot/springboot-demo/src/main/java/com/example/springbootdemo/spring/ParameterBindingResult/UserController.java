package com.example.springbootdemo.spring.ParameterBindingResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    /**
     * @Valid 指定需要验证的参数
     */
    public String add(@Valid User user, BindingResult bindingResult) {

        log.info("has error ? {}", bindingResult.hasErrors());


        // 如果有捕获到参数不合法
        if (bindingResult.hasErrors()) {


            // 得到全部不合法的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            // 遍历不合法字段
            fieldErrors.forEach(
                    fieldError -> {
                        // 获取不合法的字段名和不合法原因
                        log.info("error field is : {} ,message is : {}", fieldError.getField(), fieldError.getDefaultMessage());
                    }
            );

        }


        return user.toString();
    }
}
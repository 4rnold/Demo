package com.example.springbootdemo.spring.logback_desensitization;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RequestMapping
@RestController
public class TestController {

    @RequestMapping("/test")
    public Object test() {
        DesensitizationRequest request = new DesensitizationRequest();
        request.setEmail("aaaa@qq.com");
        request.setMobNo("13133331111");
        request.setPayPasswd("aaaassssdddd");
        request.setReceiveCardNo("410999199919199199191919");
        log.info("DesensitizationRequest params: {}", request);

        log.info("date:{}", new Date());
        log.info("string:{}", "aaaaaa");
        return request;
    }


}

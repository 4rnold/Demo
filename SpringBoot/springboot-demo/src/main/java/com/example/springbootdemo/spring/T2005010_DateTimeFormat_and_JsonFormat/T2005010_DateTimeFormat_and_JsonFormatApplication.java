package com.example.springbootdemo.spring.T2005010_DateTimeFormat_and_JsonFormat;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class,
        RedissonAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class T2005010_DateTimeFormat_and_JsonFormatApplication {

    public static void main(String[] args) {
        SpringApplication.run(T2005010_DateTimeFormat_and_JsonFormatApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("i18n/Messages"); // classpath:/i18n/Messages doesn't work
        messageSource.setFallbackToSystemLocale(false); // only fallback to the default message source file
        return messageSource;
    }

}

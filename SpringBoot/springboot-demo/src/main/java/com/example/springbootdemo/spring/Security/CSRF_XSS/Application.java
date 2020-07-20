package com.example.springbootdemo.spring.Security.CSRF_XSS;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {
        RedisAutoConfiguration.class,
        RedissonAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * csrfFilter
     * @return
     */
//    @Bean
//    public FilterRegistrationBean csrfFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
//        registration.addUrlPatterns("/*");
//        return registration;
//    }


    //[spring-boot-csrf/home.ftl at master · kabike/spring-boot-csrf](https://github.com/kabike/spring-boot-csrf/blob/master/src/main/resources/templates/home.ftl)
    @Bean
    public Module xssModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new XssJsonDeserializer());
        module.addSerializer(String.class, new XssJsonSerializer());
        return module;
    }

}

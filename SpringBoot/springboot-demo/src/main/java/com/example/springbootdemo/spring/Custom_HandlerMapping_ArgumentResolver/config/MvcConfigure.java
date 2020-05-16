package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.config;//package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.config;
//
//import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.ArgumentResolver.ApiRequestMethodArgumentResolver;
//import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.HandlerMapping.WoQuApiRequestMappingHandlerMapping;
//import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.interceptor.WoquApiHandlerInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.handler.MappedInterceptor;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import java.util.List;
//
//@Configuration
//public class MvcConfigure implements WebMvcConfigurer {
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new ApiRequestMethodArgumentResolver());
//    }
//
//
//    @Bean
//    public RequestMappingHandlerMapping apiHandlerMapping() {
//        WoQuApiRequestMappingHandlerMapping woQuApiRequestMappingHandlerMapping = new WoQuApiRequestMappingHandlerMapping();
//
//        HandlerInterceptor apiHandlerInterceptor = new WoquApiHandlerInterceptor();
//
//        MappedInterceptor mappedInterceptor = new MappedInterceptor(new String[]{"/mobile"},apiHandlerInterceptor);
//        woQuApiRequestMappingHandlerMapping.setInterceptors(mappedInterceptor);
//        return woQuApiRequestMappingHandlerMapping;
//    }
//
//
//
//}

package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.config;



import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.HandlerMapping.WoQuApiRequestMappingHandlerMapping;
import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.interceptor.WoquApiHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class Config extends WebMvcConfigurationSupport {

//    @Override
//    public RequestMappingHandlerMapping requestMappingHandlerMapping(ContentNegotiationManager contentNegotiationManager, FormattingConversionService conversionService, ResourceUrlProvider resourceUrlProvider) {
//        return super.requestMappingHandlerMapping(contentNegotiationManager, conversionService, resourceUrlProvider);
//    }


    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        WoQuApiRequestMappingHandlerMapping woQuApiRequestMappingHandlerMapping = new WoQuApiRequestMappingHandlerMapping();

        HandlerInterceptor apiHandlerInterceptor = new WoquApiHandlerInterceptor();

        MappedInterceptor mappedInterceptor = new MappedInterceptor(new String[]{"/mobile"},apiHandlerInterceptor);
        woQuApiRequestMappingHandlerMapping.setInterceptors(mappedInterceptor);
        return woQuApiRequestMappingHandlerMapping;
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        /* 是否通过请求Url的扩展名来决定media type */
        configurer.favorPathExtension(true)
                /* 不检查Accept请求头 */
                .ignoreAcceptHeader(true)
                .parameterName("mediaType")
                /* 设置默认的media yype */
                .defaultContentType(MediaType.TEXT_HTML)
                /* 请求以.html结尾的会被当成MediaType.TEXT_HTML*/
                .mediaType("html", MediaType.TEXT_HTML)
                /* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON*/
                .mediaType("json", MediaType.APPLICATION_JSON);
    }
}

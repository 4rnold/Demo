package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.ArgumentResolver.ApiRequestMethodArgumentResolver;
import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.annotation.ApiCmdMapping;
import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.requestheader.Req_header;
import org.apache.commons.io.IOUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截 请求带有@ApiCmdMapping注解的 Handler
 * 
 * @author HP
 * 
 */
public class WoquApiHandlerInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		ApiCmdMapping apiCmdMapping = AnnotationUtils.findAnnotation(
				handlerMethod.getMethod(), ApiCmdMapping.class);

		// 没有@ApiCmdMapping 什么都不做
		if (apiCmdMapping == null) {
			return true;
		} else {
			// fixed AJAX跨域
			fixedCrossDomainAjax(request, response);
			
			// 解析请求信息 放到attribute属性中给后面 ApiRequestMethodArgumentResolver 使用
			parseApiRequestInfo(request);
			
			return true;
		}
	}
	
	/**
	 * 解析请求信息 放到attribute属性中给后面 ApiRequestMethodArgumentResolver 使用
	 * @see ApiRequestMethodArgumentResolver
	 * @param request
	 */
	private void parseApiRequestInfo(HttpServletRequest request) {
		try {
			String reqStr = IOUtils.toString(request.getInputStream());
			JSONObject reqJson = JSON.parseObject(reqStr);
			JSONObject header_json = reqJson.getJSONObject("Req_Header");
			Req_header reqHeader = JSON.toJavaObject(header_json, Req_header.class);
			request.setAttribute(ApiRequestMethodArgumentResolver.REQ_HEADER_CLASS_ATTRIBUTE,
					reqHeader);
			JSON reqBodyJson = reqJson.getJSONObject("Req_Body");
			request.setAttribute(ApiRequestMethodArgumentResolver.REQ_BODY_JSON_ATTRIBUTE, reqBodyJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解决m.woqu.com 请求api.woqu.com的AJAX跨域
	 * @param request
	 * @param response
	 */
	private void fixedCrossDomainAjax(HttpServletRequest request,
                                      HttpServletResponse response) {
        String protocal =request.getHeader("X-Forwarded-Proto");
	
        if(protocal==null || protocal.equalsIgnoreCase("http")) {
        	response.addHeader("Access-Control-Allow-Credentials", "true");
        	response.addHeader("Access-Control-Allow-Origin", "http://m.woqu.com");  
        }else if(protocal.equalsIgnoreCase("https")){
        	response.addHeader("Access-Control-Allow-Credentials", "true");
        	response.addHeader("Access-Control-Allow-Origin", "https://m.woqu.com");
        }
	}
	

	
}

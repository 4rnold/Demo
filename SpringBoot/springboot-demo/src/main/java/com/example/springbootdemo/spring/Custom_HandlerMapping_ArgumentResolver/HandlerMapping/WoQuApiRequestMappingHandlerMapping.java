package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.HandlerMapping;


import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.annotation.ApiCmdMapping;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 添加自定义条件到HandlerMapping里
 * @author HP
 *
 */
public class WoQuApiRequestMappingHandlerMapping extends
        RequestMappingHandlerMapping {
	
	/**
	 * 方法级自定义条件
	 */
	@Override
	protected RequestCondition<?> getCustomMethodCondition(Method method) {
		ApiCmdMapping apiRequestMapping = AnnotationUtils.findAnnotation(method, ApiCmdMapping.class);
		if(apiRequestMapping != null){
			String[] cmds = apiRequestMapping.value();
			return new ApiRequestCondition(cmds);
		}else {
			return null;
		}
		
	}
	
	/**
	 * 类级自定义条件：不支持
	 */
	@Override
	protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
		return super.getCustomTypeCondition(handlerType);
	}

}

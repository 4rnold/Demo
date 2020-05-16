package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.controller;


import com.alibaba.fastjson.JSON;

import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.annotation.ApiCmdMapping;
import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.annotation.ReqBodyJson;
import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.requestheader.Req_header;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ApiController1 {
	
	/**
	 * 
	 * @param req_header
	 * 			    直接传入 {@link Req_header}的参数
	 * @param reqBodyJson
	 *            直接传入 JSON 格式的reqBodyJson 的参数  (需要加注解 @ReqBodyJson)
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiCmdMapping("cmd_name1")
	public @ResponseBody
    JSON mobile(Req_header req_header, @ReqBodyJson JSON reqBodyJson, HttpServletRequest request,
                HttpServletResponse response) {
		System.out.println(reqBodyJson);
		return reqBodyJson;
	}

	@ApiCmdMapping("cmd_name2")
	public @ResponseBody
    String mobile2() {
		return "api response2";
	}

}

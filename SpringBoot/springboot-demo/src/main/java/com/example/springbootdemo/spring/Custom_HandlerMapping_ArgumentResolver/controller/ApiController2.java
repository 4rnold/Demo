package com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.controller;



import com.example.springbootdemo.spring.Custom_HandlerMapping_ArgumentResolver.annotation.ApiCmdMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController2 {
	
	@ApiCmdMapping({"cmd_name4", "cmd_name41"})
	public @ResponseBody
    String mobile() {
		return "both mapping 'cmd_name4' and 'cmd_name41'";
	}
	
	@ApiCmdMapping(value = "cmd_name5")
	public @ResponseBody
    String mobile2(){
		return "mapping cmd_name5";
	}
	
}

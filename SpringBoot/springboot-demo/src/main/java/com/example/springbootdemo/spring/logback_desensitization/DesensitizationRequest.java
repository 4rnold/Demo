package com.example.springbootdemo.spring.logback_desensitization;

import lombok.Data;

@Data
@Desensitization
public class DesensitizationRequest {
 
  @Desensitization(type = "CARD")
  private String receiveCardNo;
 
  @Desensitization(type = "MOBILE")
  private String mobNo;
 
  @Desensitization(type = "EMAIL")
  private String email;
 
  @Desensitization(type = "PASSWORD")
  private String payPasswd;
 
}
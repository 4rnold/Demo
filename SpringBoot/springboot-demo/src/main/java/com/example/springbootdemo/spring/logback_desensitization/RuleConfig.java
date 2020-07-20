package com.example.springbootdemo.spring.logback_desensitization;

import lombok.Data;

@Data
public class RuleConfig {
    private String reg;
    private String replacement;
    RuleConfig(String reg, String replacement) {
        this.reg = reg;
        this.replacement = replacement;
    }
}
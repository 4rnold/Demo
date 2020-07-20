package com.example.springbootdemo.spring.logback_desensitization;

import java.util.Map;

public class StringDesc<T> {
    public Map<String, RuleConfig> rulesMap;
    public T bean;
    public T getBean() {
        return bean;
    }
    public void setBean(T bean) {
        this.bean = bean;
    }
    public void setRulesMap(Map<String, RuleConfig> rulesMap) {
        this.rulesMap = rulesMap;
    }
    public String desensitization(Object object, String ruleName){
        String result = null;
        if (object != null){
            String s = object.toString();
            if (rulesMap != null && ruleName != null && rulesMap.get(ruleName) != null){
                RuleConfig ruleConfig = rulesMap.get(ruleName);
                result=  s.replaceAll(ruleConfig.getReg(), ruleConfig.getReplacement());
            }else {
                result = "*********";
            }
        }
        return result;
    }
}
package com.example.springbootdemo.spring.logback_desensitization;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DesensitizationMessageConverter extends MessageConverter {
    private static Map<String, RuleConfig> relusMap;
    private static boolean isInit = false;
    @Override
    public String convert(ILoggingEvent event) {
        if (!isInit) init();
        return doConvert(event);
    }
    private void init() {
        synchronized (DesensitizationMessageConverter.class) {
            relusMap = new HashMap<>();
            Map<String, String> propertyMap = ((LoggerContext) LoggerFactory.getILoggerFactory()).getCopyOfPropertyMap();
            for (Map.Entry<String, String> entry : propertyMap.entrySet()) {
                String ruleName = entry.getKey();
                String value = entry.getValue();
                String[] array = value.split("&");
                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                    RuleConfig rc = new RuleConfig(array[0], array[1]);
                    relusMap.put(ruleName, rc);
                }
            }
            isInit = true;
        }
    }
    private String doConvert(ILoggingEvent event) {
        boolean isDesensitization = false;
        Object[] argumentArray = event.getArgumentArray();
        if (argumentArray != null && argumentArray.length > 0) {
            for (Object obj : argumentArray) {
                Desensitization annotation = obj.getClass().getAnnotation(Desensitization.class);
                if (annotation != null) {
                    isDesensitization = true;
                    break;
                }
            }
            if (isDesensitization) {
                List desensitization = desensitization(argumentArray);
                return MessageFormatter.arrayFormat(event.getMessage(), desensitization.toArray()).getMessage();
            }
        }
        return event.getFormattedMessage();
    }
    private List desensitization(Object[] argumentArray) {
        List argumentList = new ArrayList();
        for (Object obj : argumentArray) {
            Class<?> aClass = obj.getClass();
            Desensitization annotation = aClass.getAnnotation(Desensitization.class);
            StringDesc stringDesc = DynamicToStringObject.getStringDesc(aClass);
            if (stringDesc != null) {
                stringDesc.setBean(obj);
                stringDesc.setRulesMap(relusMap);
                argumentList.add(stringDesc);
            } else {
                argumentList.add(obj);
            }
        }
        return argumentList;
    }
 
}
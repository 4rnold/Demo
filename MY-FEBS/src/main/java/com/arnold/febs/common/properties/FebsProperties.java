package com.arnold.febs.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = "classpath:febs.properties")
@ConfigurationProperties(prefix = "febs")
public class FebsProperties {
    private ShiroProperties shiro = new ShiroProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();
}

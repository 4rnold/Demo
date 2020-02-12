package com.arnold.febs.common.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class StartedUpRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

/*        InetAddress address = InetAddress.getLocalHost();
        String url = String.format("http://%s:%s", address.getHostAddress(), port);
        String loginUrl = febsProperties.getShiro().getLoginUrl();
        if (StringUtils.isNotBlank(contextPath))
            url += contextPath;
        if (StringUtils.isNotBlank(loginUrl))
            url += loginUrl;
        if (auto && StringUtils.equalsIgnoreCase(active, "dev")) {
            String os = System.getProperty("os.name");
            // 默认为 windows时才自动打开页面
            if (StringUtils.containsIgnoreCase(os, "windows")) {
                //使用默认浏览器打开系统登录页
                Runtime.getRuntime().exec("cmd  /c  start " + url);
            }
        }*/
    }
}

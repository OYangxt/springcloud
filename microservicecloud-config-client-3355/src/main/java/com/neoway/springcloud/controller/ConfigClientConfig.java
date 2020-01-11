package com.neoway.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 20190712713
 * @date 2019/12/4 9:05
 */
@RefreshScope
@RestController
public class ConfigClientConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;

    @Value("${eureka.client.service-url.defaultZone}")
    private String defaultZone;

    @RequestMapping(value = "/config")
    public String getConfig(){
        return serverPort + ": " + applicationName + ": " + defaultZone;
    }
}

package com.neoway.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 20190712713
 * @date 2019/10/31 17:13
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7002Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002Application.class,args);
    }
}

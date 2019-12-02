package com.neoway.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author 20190712713
 * @date 2019/12/2 15:15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.neoway.springcloud")
public class DeptConsumer80ApplicationFeign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80ApplicationFeign.class, args);
    }
}

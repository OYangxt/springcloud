package com.neoway.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 20190712713
 * @date 2019/10/31 11:14
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001Application.class, args);
    }
}

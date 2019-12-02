package com.neoway.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 20190712713
 * @date 2019/12/2 16:29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class DeptProviderApplicationHystrix {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplicationHystrix.class,args);
    }
}

package com.neoway.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 20190712713
 * @date 2019/12/2 19:34
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerApplicationDashboard {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplicationDashboard.class, args);
    }
}

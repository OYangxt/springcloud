package com.neoway.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 20190712713
 * @date 2019/12/7 15:53
 */
@SpringBootApplication
@EnableEurekaClient
public class FileUploadApplication8050 {
    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication8050.class,args);
    }
}

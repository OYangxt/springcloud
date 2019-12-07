package com.neoway.springcloud;

import com.neoway.springcloud.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author 20190712713
 * @date 2019/12/3 15:08
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication9527 {
    public static void main(String[] args) {

        SpringApplication.run(ZuulApplication9527.class,args);

    }

    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }
}

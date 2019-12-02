package com.neoway.springcloud.controller;

import com.neoway.springcloud.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 20190712713
 * @date 2019/12/2 19:34
 */
@RestController
public class DeptController {
    private static String REST_URL_PREFIX = "http://microservicecloud-dept";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id, Dept.class);
    }
}

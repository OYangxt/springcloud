package com.neoway.springcloud.controller;

import com.neoway.springcloud.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 20190712713
 * @date 2019/10/31 15:39
 */
@RestController
public class DeptConsumerController {

//    private static final String REST_URL_PREFIX = "http://localhost:8001";

    private static final String REST_URL_PREFIX = "http://microservicecloud-dept";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+id, Dept.class);
    }

    @GetMapping("/discovery/dept/get/{id}")
    public Dept getDiscovery(@PathVariable("id") Long id){
        String serviceId = "microservicecloud-dept";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        ServiceInstance serviceInstance = instances.get(0);

        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        return restTemplate.getForObject("http://"+host + ":" + port + "/dept/get/" +id, Dept.class);
    }

}

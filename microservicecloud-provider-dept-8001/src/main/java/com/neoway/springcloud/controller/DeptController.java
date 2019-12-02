package com.neoway.springcloud.controller;

import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author 20190712713
 * @date 2019/10/31 11:05
 */
@RestController

public class DeptController {
    @Autowired
    private DeptService deptService;


    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {

        return deptService.addDept(dept);
    }


    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.findById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.findAll();
    }

}

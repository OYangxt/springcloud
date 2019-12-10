package com.neoway.springcloud.controller;

import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "部门信息查询", description = "部门信息查询")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @PostMapping("/dept/add")
    @ApiOperation("新增部门信息")
    public boolean addDept(@RequestBody Dept dept) {

        return deptService.addDept(dept);
    }

    @ApiOperation("根据Id查询部门信息")
    @ApiImplicitParam(name = "id", value = "部门的id", required = true, dataType = "long")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.findById(id);
    }

    @ApiOperation("查询所有部门信息")
    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.findAll();
    }

}

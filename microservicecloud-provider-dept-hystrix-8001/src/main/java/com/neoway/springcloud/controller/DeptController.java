package com.neoway.springcloud.controller;

import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 20190712713
 * @date 2019/12/2 16:28
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "getByHystrix")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);

        if(dept == null) {
            throw new RuntimeException("数据库中不存在id为"+ id + "的记录！");
        }
        return dept;
    }

    public Dept getByHystrix(@PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDeptNum(id);
        dept.setDeptName("该ID："+id+"没有没有对应的信息,null--@HystrixCommand");
        dept.setDbSource("no this database in MySQL");
        return dept;
    }

}

package com.neoway.springcloud.controller;

import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 20190712713
 * @date 2019/12/2 14:53
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientFeign deptClientFeign;


    @RequestMapping(value ="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id) {
        return this.deptClientFeign.get(id);
    }
    @RequestMapping(value ="/consumer/dept/list")
    public List<Dept> list() {
        return this.deptClientFeign.list();
    }

}

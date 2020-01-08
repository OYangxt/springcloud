package com.neoway.springcloud.controller;

import com.github.pagehelper.PageInfo;
import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import com.neoway.springcloud.util.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 20190712713
 * @date 2019/10/31 11:05
 */
@RestController
@Api(tags = "部门信息查询", description = "部门信息查询")
@Slf4j
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
    public HttpResult get(@PathVariable(value = "id") String id){
      //@PathVariable注解标识的参数，会拼接到URL中，此处无需判断参数传递；
        try {
            Dept dept=  deptService.findById(id);
            return HttpResult.returnSuccess(dept);
        }catch (Exception e) {
            log.info("部门信息查询失败！");
            return HttpResult.returnFail("部门信息查询失败！");
        }


    }

    @ApiOperation("查询所有部门信息")
    @GetMapping("/dept/list")
    public HttpResult list(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "pageSize") int pageSize){
        PageInfo<Dept> deptPageInfo = deptService.findAll(pageNum, pageSize);
        return HttpResult.returnSuccess(deptPageInfo);
    }

}

package com.neoway.springcloud.service;

import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.impl.DeptClientFallbackFactroy;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 20190712713
 * @date 2019/12/2 15:21
 */
@FeignClient(value = "microservicecloud-dept", fallbackFactory = DeptClientFallbackFactroy.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> list();

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    boolean add(Dept dept);
}

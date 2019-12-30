package com.neoway.springcloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neoway.springcloud.mapper.DeptMapper;
import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.redis.DeptInfoRedisDao;
import com.neoway.springcloud.service.DeptService;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 20190712713
 * @date 2019/10/31 11:03
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Autowired
    private DeptInfoRedisDao deptInfoRedisDao;

    @Override
    public boolean addDept(Dept dept) {

        if (deptMapper.addDept(dept) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public Dept findById(String id) {
        Dept dept;

        Map<String, String> deptMap = deptInfoRedisDao.findDeptInfo(id);

        if (!CollectionUtils.isEmpty(deptMap)) {

            dept = new Dept();

            dept.setDeptNum(Long.parseLong(deptMap.get("deptId")));
            dept.setDeptName(deptMap.get("deptName"));
            dept.setDbSource(deptMap.get("dbSource"));
            log.info("从Redis缓存中取出了部门信息....{}",deptMap);

            return dept;
        }


        dept = deptMapper.findById(id);
        Map<String, String> newDeptMap = new HashMap<>(3);
        newDeptMap.put("deptId",String.valueOf(dept.getDeptNum()));
        newDeptMap.put("deptName", dept.getDeptName());
        newDeptMap.put("dbSource",dept.getDbSource());
        deptInfoRedisDao.updateDeptInfo(id, newDeptMap);
        log.info("将部门信息存入Redis数据库中...{}",dept);
        return dept;
    }

    @Override
    public PageInfo<Dept> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Dept> depts = deptMapper.findAll();
        PageInfo<Dept> pageInfo = new PageInfo<>(depts);

        return pageInfo;
    }
}

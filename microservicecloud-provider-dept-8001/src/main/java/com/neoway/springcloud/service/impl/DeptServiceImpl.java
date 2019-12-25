package com.neoway.springcloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neoway.springcloud.mapper.DeptMapper;
import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private RedisTemplate redisTemplate;

    @Override
    public boolean addDept(Dept dept) {

        if (deptMapper.addDept(dept) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public Dept findById(Long id) {
        Dept dept;
        String key = "dept_" + id;

        ValueOperations<String, Dept> ops = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            dept = ops.get(key);
            log.info("从Redis缓存中取出了部门信息....{}",dept);
            return dept;
        }

        dept = deptMapper.findById(id);
        ops.set(key, dept, 15, TimeUnit.MINUTES);
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

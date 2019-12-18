package com.neoway.springcloud.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neoway.springcloud.mapper.DeptMapper;
import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 20190712713
 * @date 2019/10/31 11:03
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {

        if (deptMapper.addDept(dept) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public Dept findById(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public PageInfo<Dept> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Dept> depts = deptMapper.findAll();
        PageInfo<Dept> pageInfo = new PageInfo<>(depts);

        return pageInfo;
    }
}

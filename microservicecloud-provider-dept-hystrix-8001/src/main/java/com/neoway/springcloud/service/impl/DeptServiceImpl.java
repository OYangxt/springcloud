package com.neoway.springcloud.service.impl;

import com.neoway.springcloud.mapper.DeptMapper;
import com.neoway.springcloud.model.Dept;
import com.neoway.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 20190712713
 * @date 2019/12/2 16:28
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept findById(Long id) {
        return deptMapper.findById(id);
    }

}

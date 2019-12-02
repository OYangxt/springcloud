package com.neoway.springcloud.service;

import com.neoway.springcloud.model.Dept;

public interface DeptService {


    /**
     * 依据id查询部门
     * @param id 待查询部门id
     * @return 部门对象
     */
    Dept findById(Long id);

}

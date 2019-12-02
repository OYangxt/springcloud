package com.neoway.springcloud.service;

import com.neoway.springcloud.model.Dept;

import java.util.List;

/**
 * @author 20190712713
 * @date 2019/10/31 11:02
 */
public interface DeptService {
    /**
     * 添加部门信息
     * @param dept 待添加部门实体
     */
    boolean addDept(Dept dept);

    /**
     * 依据id查询部门
     * @param id 待查询部门id
     * @return 部门对象
     */
    Dept findById(Long id);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();
}

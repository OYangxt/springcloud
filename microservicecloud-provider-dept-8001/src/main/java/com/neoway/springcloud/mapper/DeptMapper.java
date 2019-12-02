package com.neoway.springcloud.mapper;

import com.neoway.springcloud.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 20190712713
 * @date
 */
@Mapper
public interface DeptMapper {

    /**
     * 添加部门信息
     * @param dept 待添加部门实体
     * @return
     */
    int addDept(@Param(value = "dept")Dept dept);

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

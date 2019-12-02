package com.neoway.springcloud.mapper;

import com.neoway.springcloud.model.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 20190712713
 * @date 2019/12/2 16:26
 */
@Mapper
public interface DeptMapper {


    /**
     * 依据id查询部门
     * @param id 待查询部门id
     * @return 部门对象
     */
    Dept findById(Long id);

}

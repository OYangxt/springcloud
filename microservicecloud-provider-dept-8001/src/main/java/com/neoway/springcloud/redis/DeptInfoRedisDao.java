package com.neoway.springcloud.redis;

import java.util.Map;

/**
 * @author 20190712713
 * @date 2019/12/30 17:05
 */
public interface DeptInfoRedisDao {
    /**
     * 更新Redis中部门信息
     * @param deptId
     * @param value
     */
    void updateDeptInfo(String deptId, Map<String, String> value);

    /**
     * 根据部门信息查找
     * @param deptId
     * @return
     */
    Map<String, String> findDeptInfo(String deptId);
}

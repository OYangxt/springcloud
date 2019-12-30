package com.neoway.springcloud.redis.impl;

import com.neoway.springcloud.redis.DeptInfoRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 20190712713
 * @date 2019/12/30 17:11
 */
@Service
public class DeptInfoRedisDaoImpl implements DeptInfoRedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void updateDeptInfo(String deptId, Map<String, String> value) {
        stringRedisTemplate.boundHashOps("oyxt:example:dept" +deptId).putAll(value);
        stringRedisTemplate.boundHashOps("oyxt:example:dept" +deptId).expire(15, TimeUnit.MINUTES);

    }

    @Override
    public Map<String,String> findDeptInfo(String deptId) {

        return stringRedisTemplate.<String,String>boundHashOps("oyxt:example:dept" +deptId).entries();
    }
}

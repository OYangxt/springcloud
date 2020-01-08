package com.oyxt.example.test;

import cn.hutool.core.bean.BeanUtil;
import com.oyxt.example.mode.Student;
import org.junit.Test;

/**
 * @author 20190712713
 * @date 2020/1/8 9:47
 */
public class HutoolTest {

    @Test
    public void beanUtilTest() {
        Student studentA = new Student();
        studentA.setAge(11);
        studentA.setName("OY");
        studentA.setSex("m");

        Student studentB = new Student();
        BeanUtil.copyProperties(studentA,studentB);
        System.out.println(studentB);

    }


}

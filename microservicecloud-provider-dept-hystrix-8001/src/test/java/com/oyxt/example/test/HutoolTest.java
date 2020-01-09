package com.oyxt.example.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.oyxt.example.mode.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Test
    public void dateUtilTest() {
        //String2Date
        String date1 = "2020-01-08 16:55:32";



        Date date1Time = DateUtil.parse(date1);
        System.out.println(date1Time.toString());

        Date date2Time = DateUtil.parse(date1, "yyyy-MM-dd");
        System.out.println(date2Time);

        System.out.println(DateUtil.formatDateTime(date1Time));
        System.out.println(DateUtil.formatDate(date1Time));
        System.out.println(DateUtil.formatTime(date1Time));
        System.out.println(DateUtil.format(date1Time, "yyyy-MM-dd"));

        Date now = new Date();

        System.out.println("======================================================");
        System.out.println("时间间隔");
        long sec =  DateUtil.between(now, date1Time, DateUnit.SECOND);
        System.out.println(sec);

        System.out.println(DateUtil.formatBetween(now, date1Time));

        DateTime date = DateUtil.date();
        System.out.println(date);
    }

    @Test
    public void randomUtilTest() {
        //a.随机产生一个int数
        System.out.println(RandomUtil.randomInt());

        //b.随机产生一个小于10的int的数
        System.out.println(RandomUtil.randomInt(10));

        //c.随机产生一个<200且>=100的int数
        System.out.println(RandomUtil.randomInt(100, 102));

        //d.从指定字符串中产生一个随机字符
        System.out.println(RandomUtil.randomChar("smart"));

        //e.产生一个随机int数
        System.out.println(RandomUtil.randomNumber());

        //f.随机产生一个指定长度的字符串（只包含数字）
        System.out.println(RandomUtil.randomNumbers(4));

        //g.随机产生一个指定长度的字符串(只包含数字和字符）
        System.out.println(RandomUtil.randomString(5));

        //h.从指定字符串中随机产生指定长度的字符串(所有字符来源于指定字符串）
        System.out.println(RandomUtil.randomString("smartPig", 4));

        //i.从List中随机产生一个数据
        List<Integer> list = Arrays.asList(11, 52, 3, 40, 51, 96);
        System.out.println(RandomUtil.randomEle(list));

        //j.从List前n个数据中随机产生一个数据（n从1开始）
        System.out.println(RandomUtil.randomEle(list, 6));

        //k.从数组中随机产生一个数据
        Integer array01[] = {1, 2, 3, 4, 5, 6};
        System.out.println(RandomUtil.randomEle(array01));
    }


    /**
     * 正则工具测试
     */
    @Test
    public void regularUtilTest() {
        String qqMail = "747504139@qq.com";


    }
}

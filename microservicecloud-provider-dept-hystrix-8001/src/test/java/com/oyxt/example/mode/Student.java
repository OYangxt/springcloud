package com.oyxt.example.mode;

import lombok.Data;

/**
 * @author 20190712713
 * @date 2020/1/8 9:42
 */
@Data
public class Student {
    private String name;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

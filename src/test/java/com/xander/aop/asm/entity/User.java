package com.xander.aop.asm.entity;

import com.xander.aop.asm.annotation.Mark;

import java.io.Serializable;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
@Mark(name = "user")
public class User implements Serializable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.xander.designpattern.reuseclass.dynamicproxy;

/**
 * Created by zhaobing04 on 2018/4/12.
 */

public class SleepImpl implements ISleep {
    @Override
    public void sleep() {
        System.out.println("i'm sleep");
    }
}

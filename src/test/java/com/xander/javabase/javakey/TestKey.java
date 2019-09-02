package com.xander.javabase.javakey;

import com.xander.javabase.javakey.defaultkey.DefaultClass;

/**
 * Created by zhaobing04 on 2019/3/13.
 */
public class TestKey {

    public static void main(String args[]){
        testDefault();
    }

    /**
     * 测试default 关键字
     */
    public static void testDefault(){
        DefaultClass defaultClass = new DefaultClass();
        defaultClass.printf("test default class");
    }
}

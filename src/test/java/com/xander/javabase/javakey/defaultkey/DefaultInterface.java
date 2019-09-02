package com.xander.javabase.javakey.defaultkey;

/**
 * Created by zhaobing04 on 2019/3/13.
 */
public interface DefaultInterface {
    void printf();

    static void staticPrintf(String str){
        System.out.println(str);
    }

    default void printf(String str){
        System.out.println(str);
    }
}

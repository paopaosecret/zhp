package com.xander.lambda;

/**
 * Created by zhaobing04 on 2020/7/7.
 * 定义一个普通接口
 */
public interface IHandler2 {
    int handler2(String str);
    default void run(){
        System.out.println("handler2 start");
    }
}

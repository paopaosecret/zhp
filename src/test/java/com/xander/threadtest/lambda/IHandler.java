package com.xander.threadtest.lambda;

/**
 * Created by zhaobing04 on 2020/7/7.
 * 定义一个函数式接口
 */
@FunctionalInterface
public interface IHandler {
    int handler(String str);
    default void run(){
        System.out.println("handler start");
    }
}

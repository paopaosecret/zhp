package com.xander.threadtest.lambda;

/**
 * Created by zhaobing04 on 2020/7/7.
 */
public class Request implements IHandler,IHandler2 {
    @Override
    public int handler2(String str) {
        return 0;
    }

    @Override
    public int handler(String str) {
        return 1;
    }

    @Override
    public void run() {
//        IHandler.super.run();可以使用IHandler父类的默认run方法
        System.out.println("request run"); //也可以自定义run方法
    }
}

package com.xander.lambda;

/**
 * Created by zhaobing04 on 2020/7/7.
 */
public class Handler implements IHandler {
    @Override
    public int handler(String str) {
        System.out.println("handler:"+ str);
        return 1;
    }
}

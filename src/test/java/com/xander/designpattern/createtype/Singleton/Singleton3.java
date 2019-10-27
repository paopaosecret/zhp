package com.xander.designpattern.createtype.Singleton;

/**
 * Created by zhaobing04 on 2019/9/30.
 *
 * 使用枚举模拟单例
 */
public enum Singleton3 {
    INSTANCE;
    public void printf(){
        System.out.println("Hello word");
    }

    public static void main(String[] args) {
        Singleton3.INSTANCE.printf();
    }
}

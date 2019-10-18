package com.xander.designpattern.createtype.Singleton;

/**
 * Created by zhaobing04 on 2019/9/30.
 * 使用静态内部类实现单例模式--线程安全
 * 加载一个类时，其内部类不会同时被加载。
 * 一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
 */
public class Singleton2 {
    private Singleton2(){}

    private static class Singleton2Holder{
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return Singleton2Holder.instance;
    }
}

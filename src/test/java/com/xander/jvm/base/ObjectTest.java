package com.xander.jvm.base;

/**
 * Created by zhaobing04 on 2019/9/11.
 */
public class ObjectTest {

    public static void main(String args[]){
        Object obj = new Object();
        Object1 obj1 = new Object1();
        Object2 obj2 = new Object2();

        System.gc();
    }

    static class Object1{
        int i = 10;
    }

    static class Object2{
        long l = 10L;
    }
}

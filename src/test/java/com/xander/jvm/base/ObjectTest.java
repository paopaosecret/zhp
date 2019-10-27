package com.xander.jvm.base;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * Created by zhaobing04 on 2019/9/11.
 */
public class ObjectTest {

    public static void main(String args[]){
        Object obj = new Object();
        Object1 obj1 = new Object1();
        Object2 obj2 = new Object2();

        long objSize = ObjectSizeCalculator.getObjectSize(obj);
        long obj1Size = ObjectSizeCalculator.getObjectSize(obj1);
        long obj2Size = ObjectSizeCalculator.getObjectSize(obj2);

        System.out.println("Object size:" + objSize);
        System.out.println("Object size:" + obj1Size);
        System.out.println("Object size:" + obj2Size);
    }

    static class Object1{
        int i = 10;
        boolean b = true;
    }

    static class Object2{
        long l = 10L;
    }
}

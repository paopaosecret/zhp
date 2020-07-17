package com.xander.javabase.extendsclass;

/**
 * Created by zhaobing04 on 2020/7/10.
 */
public class Base {
    public void printf(){
        System.out.println(this.getClass().getSimpleName());   //返回具体子类的类名
        System.out.println(this.getClass().getName());         //返回具体子类的全限定类名
        System.out.println(this.getClass().getCanonicalName());
    }
}

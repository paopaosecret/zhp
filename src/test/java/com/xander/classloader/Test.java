package com.xander.classloader;

import com.xander.aop.asm.MyClassLoader;
import com.xander.javabase.parameters.bean.Apple;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class Test {
    /**
     * 父
     * @param args
     */
    public static void main(String args[]){
        ClassLoader c = Test.class.getClassLoader();  //AppClassLoader  加载
        System.out.println(c);
        System.out.println("ClassLoader 的类加载器：" + ClassLoader.class.getClassLoader());
        System.out.println("MyClassLoader 的类加载器：" + MyClassLoader.class.getClassLoader());
        try {
            MyClassLoader cl = new MyClassLoader();
            Class<?>  appleClass = (Class<?>) (cl.findClass("com.xander.javabase.parameters.bean.Apple"));
            Apple apple = (Apple) appleClass.newInstance();
            System.out.println("appleClass 的类加载器:" + appleClass.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClassLoader c1 = c.getParent();            //AppClassLoader 的父加载器为ExtClassLoader
        System.out.println(c1);

        ClassLoader c2 = c1.getParent();        //ExtClassLoader 的父加载器为BootstrapLoader ，该加载器c++编写，所以为null
        System.out.println(c2);

        System.out.println(String.class.getClassLoader()); //rt.jar中的类加载器为BootstrapLoader， 所以为空
    }
}

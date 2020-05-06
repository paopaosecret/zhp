package com.xander.jvm.classloader;

import java.lang.reflect.Method;

/**
 * Created by zhaobing04 on 2020/4/9.
 */
public class Test {
    public static void main(String[] args) {
//      testClassLoader();
        testCustomClassLoader();
    }

    /**
     * 打印系统classLoader关系
     */
    public static void testClassLoader(){
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println("classloader:" + classLoader);

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println("classloader1:" + classLoader1);

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println("classloader2:" + classLoader2);
    }

    /**
     * 测试自定义classloader
     */
    public static void testCustomClassLoader(){
        CustomClassLoader customClassLoader = new CustomClassLoader("file:///D:/classloader/");
        try{
            Class c = customClassLoader.loadClass("TestBean");
            if(c != null){
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("print", null);
                method.invoke(obj, null);
            }else{
                System.out.println("类未空");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("异常");
        }
    }
}

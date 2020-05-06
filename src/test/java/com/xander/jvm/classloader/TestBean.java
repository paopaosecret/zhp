package com.xander.jvm.classloader;

/**
 * Created by zhaobing04 on 2020/4/9.
 *
 * 我测试：注销掉package语句，将代码复制到d://classloader/文件夹下并使用javac编译得到class字节码
 */
public class TestBean {
    public void print(){
        System.out.println("hello classloader");
    }
}

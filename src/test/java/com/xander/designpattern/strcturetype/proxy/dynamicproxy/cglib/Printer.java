package com.xander.designpattern.strcturetype.proxy.dynamicproxy.cglib;

/**
 * Created by zhaobing04 on 2020/6/29.
 * CGLIB使用第一步：
 * 创建目标类
 */
public class Printer {
    public void print(String file){
        System.out.println("打印文件:" + file);
    }

    final public void open(){
        System.out.println("打开打印机器");
    }

    final public void close(){
        System.out.println("关闭打印机器");
    }
}

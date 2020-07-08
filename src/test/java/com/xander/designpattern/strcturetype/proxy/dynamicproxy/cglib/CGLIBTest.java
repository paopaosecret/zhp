package com.xander.designpattern.strcturetype.proxy.dynamicproxy.cglib;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by zhaobing04 on 2020/6/29.
 */
public class CGLIBTest {

    public static void main(String[] args) {
        //开启CGLIB的debug,在指定目录下生成动态代理类，可以反编译看生成的文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\temp\\java_home");

        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();

        //设置目标类的字节码文件
        enhancer.setSuperclass(Printer.class);
        //设置回调函数
        enhancer.setCallback(new PrinterInterceptor());

        //这里的creat方法就是正式创建代理类
        Printer proxyPrinter = (Printer) enhancer.create();
        //调用代理类的eat方法
        proxyPrinter.print("答辩论文");
    }
}

package com.xander.designpattern.strcturetype.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhaobing04 on 2020/6/29.
 * * CGLIB使用第二步：
 * 创建方法拦截器
 */
public class PrinterInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("==============对目标方法进行增强=============");

        //方法的调用，直接调用，非反射
        Object object = proxy.invokeSuper(o, args);

        System.out.println("==============对目标方法进行增强完成=============");
        return object;
    }
}

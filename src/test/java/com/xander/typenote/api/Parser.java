package com.xander.typenote.api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by zhaobing04 on 2019/3/1.
 */
public class Parser {

    public <T extends Response> T buildResponse(CallBack callBack,Request request) {
        T response = null;
         //获取当前类的父类的类型
        Type type = callBack.getClass().getGenericSuperclass();
        //将父类的类型转换成范型的类型，然后获取范型类型的第一个参数
        Type t = ((ParameterizedType) type).getActualTypeArguments()[0];
        //判断Type类型是否是基本类型Class<?>
        if (t instanceof Class<?>) {
            //强制转换
            Class<?> c = (Class<?>) t;

            //创建对象的实例
            try {
                response = (T) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}

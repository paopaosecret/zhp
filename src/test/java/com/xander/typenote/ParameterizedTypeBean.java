package com.xander.typenote;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/2/14.
 */
public class ParameterizedTypeBean {
    static class Bean{
        Map<String, Double> map;
        Map.Entry<String, Object> entry;
        List<String> strList;
        List list;
        Holder holder;
        Holder<String> stringHolder;
        static class Holder<V> {}
    }
    public static void main(String args[]){
        Field f = null;
        try {
            Field[] fields = Bean.class.getDeclaredFields();
            // 打印出所有的 Field 的 TYpe 是否属于 ParameterizedType
            for (int i = 0; i < fields.length; i++) {
                f = fields[i];
                printParameterizedType( f.getName() );
            }


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private static void printParameterizedType(String fieldName) throws NoSuchFieldException {
        Field f;
        f = Bean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        boolean b = f.getGenericType() instanceof ParameterizedType;
        System.out.println("字段：" + fieldName + "--开始-is ParameterizedType:" + b +" --------------------------------------------------------");

        if(b){
            ParameterizedType pType = (ParameterizedType) f.getGenericType();
            System.out.println(fieldName + ".getGenericType().getTypeName()返回： " + pType.getTypeName());
            System.out.println(fieldName + ".getGenericType().getRawType()返回： " + pType.getRawType());
            System.out.println(fieldName + ".getGenericType().getOwnerType()返回： " + pType.getOwnerType());
            StringBuffer sb = new StringBuffer("");
            for (Type type : pType.getActualTypeArguments()) {
                sb.append(type);
                sb.append("----");
            }
            System.out.println(fieldName + ".getGenericType().getActualTypeArguments()= " +sb.toString()); // nul
        }
        System.out.println("字段：" + fieldName + "--结束---------------------------------------------------------\n");
    }



}

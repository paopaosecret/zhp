package com.xander.typenote;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/2/27.
 */
public class GenericArrayTypeBean {
    static class Bean{
        List<String>[] lists;
        Map<String,Animal>[] maps;
        Object[] obj;
    }

    public static void main(String[] args) {
        Bean bean = new Bean();
        Field[] fieldList = bean.getClass().getDeclaredFields();
        if(fieldList != null && fieldList.length > 0){
            for(Field field : fieldList){
                Type type = field.getGenericType();
                if(type instanceof GenericArrayType){
                    System.out.println("字段：" + field.getName() + " GenericArrayType.getGenericComponentType() 返回：" + ((GenericArrayType)type).getGenericComponentType() + "\n");
                }else{
                    System.out.println("字段：" + field.getName() + "不是GenericArrayType类型\n");
                }
            }
        }
    }
}

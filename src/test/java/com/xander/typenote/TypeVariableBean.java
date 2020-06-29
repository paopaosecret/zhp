package com.xander.typenote;

import java.io.Serializable;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/2/14.
 */
public class TypeVariableBean{

    static class Bean<K extends Animal & Serializable, V> {
        //K的上边界是Animal
        K key;

        //V的上边界没指定  默认是Object
        V value;

        V[] values;

        String str;

        List<K> kList;
    }

    public static void main(String[] args) {
        Bean bean = new Bean<Dog,String>();
        try {
            Field[] fields = bean.getClass().getDeclaredFields();
            // 打印出所有的 Field 的 TYpe 是否属于 ParameterizedType
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                if(f.getGenericType() instanceof TypeVariable){
                    TypeVariable tv = (TypeVariable) f.getGenericType();
                    System.out.println("字段：" + f.getName() + " 是TypeVariable 类型");
                    System.out.println("字段：" + f.getName() + "-->TypeVariable.getGenericDeclaration()返回：" + tv.getGenericDeclaration());
                    System.out.println("字段：" + f.getName() + "-->TypeVariable.getName()返回：" + tv.getName());
                    AnnotatedType[] annotatedTypes = tv.getAnnotatedBounds();
                    StringBuffer asb = new StringBuffer("");
                    if(annotatedTypes != null && annotatedTypes.length > 0){
                        for(AnnotatedType annotatedType : annotatedTypes){
                            asb.append(annotatedType.getType().getTypeName() + "---");
                        }
                    }
                    System.out.println("字段：" + f.getName() + "-->TypeVariable.getAnnotatedBounds()返回：" + asb.toString());
                    Type[] types = tv.getBounds();
                    StringBuffer sb = new StringBuffer("");
                    if(types != null){
                        for(Type type : types){
                            sb.append(type.getTypeName() + "---");
                        }
                    }
                    System.out.println("字段：" + f.getName() + "-->TypeVariable.getBounds()返回：" + sb.toString() + "\n");
                }else{
                    System.out.println("字段：" + f.getName() + " 不是TypeVariable 类型\n");
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}

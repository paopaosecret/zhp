package com.xander.typenote;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) {
//        getTypeFromClass();
//        getTypeFromField();
        getTypeFromMethod();
    }

    public static void getTypeFromClass(){
        Type[] types = Dog.class.getGenericInterfaces();
        for(Type type : types){
            System.out.println(type.getTypeName());
            System.out.println(getTypeName(type));
        }
    }

    public static void getTypeFromField(){
        Field[] fields = Dog.class.getDeclaredFields();
        for(Field field : fields){
            Type type = field.getGenericType();
            System.out.println(type.getTypeName());
            System.out.println(field.getName() + getTypeName(type));
        }
    }

    public static void getTypeFromMethod(){
        Method[] methods = Dog.class.getDeclaredMethods();
        for(Method method : methods){
            Type[] types = method.getGenericParameterTypes();
            for(Type type : types){
                System.out.println(type.getTypeName());
                System.out.println(getTypeName(type));
            }
        }
    }


    public static String getTypeName(Type type){
        if (type instanceof Class) {
            return "变量类型为Class";
        } else if (type instanceof ParameterizedType) {
            return "变量类型为ParameterizedType";
        } else if (type instanceof TypeVariable) {
            return "变量类型为TypeVariable";
        } else if (type instanceof GenericArrayType) {
            return "变量类型为GenericArrayType";
        } else if (type instanceof WildcardType) {
            return "变量类型为WildcardType";
        }
        return "";
    }
}

package com.xander.typenote;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/2/14.
 */
public class TypeTest<K extends Animal & Serializable,V> {
    K key;

    public static void main(String args[]) {
        Class<Dog> dogClass = Dog.class;
        System.out.println(dogClass.getGenericInterfaces()[0].getTypeName());
        System.out.println(dogClass.getTypeParameters().length);
        System.out.println(dogClass.getTypeName());

        Type type = new Type() {
            @Override
            public String getTypeName() {
                return "测试的Type";
            }
        };
        System.out.println(type.toString());
    }

}

package com.xander.javabase.parameters.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2020/6/2.
 */
public class Part1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello word");
        list.add(10);

        for(int i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

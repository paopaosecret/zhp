package com.xander.javabase.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/9/9.
 */
public class ListTest {


    private static void testSubList(){
        System.out.println(8/3);
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");

        List<String> strings1  = strings.subList(2,4);
        System.out.println(strings);
        System.out.println(strings1);
    }
}

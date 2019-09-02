package com.xander.typenote;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/2/14.
 */
public class Dog implements Animal,Serializable {

    List<String> list;

    List list1;


    @Override
    public String speak(String msg) {
        return "汪汪汪";
    }
}

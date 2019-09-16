package com.xander.javabase.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/9/9.
 */
public class MapTest {
    public static void main(String args[]){
        testPutAll();
    }

    public static void testPutAll(){
        Map<String, String> pMap = new HashMap<>();
        pMap.put("name", "zhangsan");

        Map<String, String> cMap = new HashMap<>();
        cMap.put("age","19");

        pMap.putAll(cMap);

        System.out.println(pMap);
    }
}

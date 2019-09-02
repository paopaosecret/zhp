package com.xander.javabase.javakey.defaultkey;

/**
 * Created by zhaobing04 on 2019/3/13.
 */
public class DefaultClass implements DefaultInterface {

    @Override
    public void printf() {
        System.out.println("hello word");
    }


    @Override
    public void printf(String str){
        System.out.println(str);
    }


    public void staticPrintf(String str){

    }
}

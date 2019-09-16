package com.xander.utils;

/**
 * Created by Administrator on 2019/9/16.
 */
public class StringUtils{
    public static boolean isEmpty(String str){
        if(str == null){
            return true;
        }else if(str.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

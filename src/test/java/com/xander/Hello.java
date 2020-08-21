package com.xander;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaobing04 on 2019/10/24.
 */
public class Hello {
    public static void main(String[] args) {
//        System.out.println(getIndex("https://pic1.58cdn.com.cn/nowater/sjtnw/n_v2e0fbbd250a44411ca0ed990240778cc6.png?w=291&h=218"));
        String strDateFormat = "yyyy年MM月dd日 HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(new Date()));
    }

    public static Boolean isMatchUrl(String url) {
        url = url.trim().toLowerCase();
        int i = url.indexOf("58cdn");
        return i > 0 && ((url.endsWith("css") && url.matches("\"\\\\_v(\\\\d+)\\\\.[a-zA-Z]+$\"")) ||
                (url.endsWith(".js") && url.matches("\"\\\\_v(\\\\d+)\\\\.[a-zA-Z]+$\"")) ||
                (url.endsWith("png") || url.indexOf("png") > 0) ||
                (url.endsWith("jpg") || url.indexOf("jpg") > 0));
    }

    public static String getIndex(String url){
        return url.substring( url.indexOf("58cdn.com.cn") + 13);
    }
}

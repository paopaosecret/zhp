package com.xander.json;

import com.alibaba.fastjson.JSON;
import com.xander.SymboltemBean;

import java.util.ArrayList;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class JsonTest {
    public static void main(String args[]){
        testJSON();
    }

    public static void testJSON(){
        ArrayList<com.xander.SymboltemBean> symboltemBeans = new ArrayList<>();

        com.xander.SymboltemBean bean = new com.xander.SymboltemBean();
        bean.setSymbol("selfServiceMall");
        bean.setJumpUrl("https://mshop.58.com/intelligentmarket/home/getHomeIndex?source=app_58sjt");
        symboltemBeans.add(bean);

        com.xander.SymboltemBean bean1 = new com.xander.SymboltemBean();
        bean1.setSymbol("welfarehome");
        bean1.setJumpUrl("https://mshop.58.com/intelligentmarket/home/getHomeIndex?source=app_58sjt");
        symboltemBeans.add(bean1);

        String jsnoStr = JSON.toJSONString(symboltemBeans);
        System.out.println(jsnoStr);

        ArrayList<com.xander.SymboltemBean> list = (ArrayList<com.xander.SymboltemBean>) JSON.parseArray(jsnoStr, SymboltemBean.class);
        System.out.println(JSON.toJSONString(list));
    }
}

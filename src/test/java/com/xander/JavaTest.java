package com.xander;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class JavaTest {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("即将被销毁");
        super.finalize();
    }

    public static final Object object = new Object();
    public static void main(String args[]){
        JavaTest javaTest = new JavaTest();
        javaTest = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        testJSON();
    }

    public static void testJSON(){
        ArrayList<SymboltemBean> symboltemBeans = new ArrayList<>();

        SymboltemBean bean = new SymboltemBean();
        bean.setSymbol("selfServiceMall");
        bean.setJumpUrl("https://mshop.58.com/intelligentmarket/home/getHomeIndex?source=app_58sjt");
        symboltemBeans.add(bean);

        SymboltemBean bean1 = new SymboltemBean();
        bean1.setSymbol("welfarehome");
        bean1.setJumpUrl("https://mshop.58.com/intelligentmarket/home/getHomeIndex?source=app_58sjt");
        symboltemBeans.add(bean1);

        String jsnoStr = JSON.toJSONString(symboltemBeans);
        System.out.println(jsnoStr);

        ArrayList<SymboltemBean> list = (ArrayList<SymboltemBean>) JSON.parseArray(jsnoStr, SymboltemBean.class);
        System.out.println(JSON.toJSONString(list));
    }
}
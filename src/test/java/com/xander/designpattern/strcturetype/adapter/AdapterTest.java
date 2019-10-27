package com.xander.designpattern.strcturetype.adapter;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class AdapterTest {
    public static void main(String[] args) {

        IAdapter adapter = new AdapterD2V();
        adapter.adapterData(new Data("张三", "头像"), new View());
    }
}

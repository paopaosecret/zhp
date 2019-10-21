package com.xander.designpattern.strcturetype.adapter;

/**
 * Created by zhaobing04 on 2019/10/18.
 */
public class AdapterD2V implements IAdapter{

    public void adapterData(Data data, View view){
        System.out.println(view.getTextView() + "-》显示文本内容："  + data.getName());
        System.out.println(view.getImageView() + "-》显示头像："  + data.getIcon());
    }
}

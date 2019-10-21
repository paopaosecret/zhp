package com.xander.designpattern.strcturetype.adapter;

/**
 * Created by zhaobing04 on 2019/10/18.
 *
 * 将数据适配到view中使用此模式
 * 单条数据没必要使用
 * 多条重复的数据可使用，如ListView  每条数据都具有共性，所以可以使用，提高代码利用率
 *
 */
public interface IAdapter {
    void adapterData(Data data, View view);
}

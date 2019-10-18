package com.xander.designpattern.createtype.factory.factorymethod.factory;


import com.xander.designpattern.createtype.factory.factorymethod.model.Sender;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public interface Provider {
    Sender produce();
}

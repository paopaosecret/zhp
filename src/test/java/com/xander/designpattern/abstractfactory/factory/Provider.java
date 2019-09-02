package com.xander.designpattern.abstractfactory.factory;


import com.xander.designpattern.abstractfactory.model.Sender;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public interface Provider {
    Sender produce();
}

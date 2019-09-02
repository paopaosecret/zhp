package com.xander.designpattern.abstractfactory.factory.impl;


import com.xander.designpattern.abstractfactory.factory.Provider;
import com.xander.designpattern.abstractfactory.model.Sender;
import com.xander.designpattern.abstractfactory.model.impl.QQSender;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public class QQSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new QQSender();
    }
}

package com.xander.designpattern.abstractfactory.factory.impl;

import com.xander.designpattern.abstractfactory.factory.Provider;
import com.xander.designpattern.abstractfactory.model.Sender;
import com.xander.designpattern.abstractfactory.model.impl.SmsSneder;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public class SmsSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSneder();
    }
}

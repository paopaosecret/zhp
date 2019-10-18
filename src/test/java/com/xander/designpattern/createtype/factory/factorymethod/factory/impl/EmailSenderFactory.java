package com.xander.designpattern.createtype.factory.factorymethod.factory.impl;

import com.xander.designpattern.createtype.factory.factorymethod.factory.Provider;
import com.xander.designpattern.createtype.factory.factorymethod.model.Sender;
import com.xander.designpattern.createtype.factory.factorymethod.model.impl.EmailSender;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public class EmailSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new EmailSender();
    }
}

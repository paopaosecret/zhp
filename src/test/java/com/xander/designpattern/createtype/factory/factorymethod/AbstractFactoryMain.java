package com.xander.designpattern.createtype.factory.factorymethod;

import com.xander.designpattern.createtype.factory.factorymethod.factory.Provider;
import com.xander.designpattern.createtype.factory.factorymethod.factory.impl.SmsSenderFactory;
import com.xander.designpattern.createtype.factory.factorymethod.model.Sender;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public class AbstractFactoryMain {

    public static void main(String args[]){
        Provider provider = new SmsSenderFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}

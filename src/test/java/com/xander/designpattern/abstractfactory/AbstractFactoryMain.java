package com.xander.designpattern.abstractfactory;

import com.xander.designpattern.abstractfactory.factory.Provider;
import com.xander.designpattern.abstractfactory.factory.impl.SmsSenderFactory;
import com.xander.designpattern.abstractfactory.model.Sender;

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

package com.xander.designpattern.createtype.factory.abstractfactory.factory;

import com.xander.designpattern.createtype.factory.abstractfactory.contract.IManager;
import com.xander.designpattern.createtype.factory.abstractfactory.contract.IUser;
import com.xander.designpattern.createtype.factory.abstractfactory.servie.ManagerImpl;
import com.xander.designpattern.createtype.factory.abstractfactory.servie.UserImpl;
import com.xander.designpattern.createtype.factory.factorymethod.model.Sender;
import com.xander.designpattern.createtype.factory.factorymethod.model.impl.EmailSender;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class AbstractFactory1 implements IFactory{
    @Override
    public IUser createUser(){
        return new UserImpl();
    }

    @Override
    public IManager createManager(){
        return new ManagerImpl();
    }

    @Override
    public Sender createSender() {
        return new EmailSender();
    }

    public static void main(String[] args) {
        IUser user = new AbstractFactory1().createUser();
        IManager manager = new AbstractFactory1().createManager();
        user.show();
        manager.show();
    }
}

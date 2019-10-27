package com.xander.designpattern.createtype.factory.abstractfactory.factory;

import com.xander.designpattern.createtype.factory.abstractfactory.contract.IManager;
import com.xander.designpattern.createtype.factory.abstractfactory.contract.IUser;
import com.xander.designpattern.createtype.factory.factorymethod.model.Sender;

/**
 * Created by zhaobing04 on 2019/10/17.
 *
 * AbstractFactory1 和 AbstractFactory2分别实现了创建所有对象
 *
 * 但对于不同的产品线可以创建不同的实现如{@link IFactory#createSender()}的实现，两个工厂使用不同的组件
 *
 */
public interface IFactory {
    IUser createUser();
    IManager createManager();
    Sender createSender();
}

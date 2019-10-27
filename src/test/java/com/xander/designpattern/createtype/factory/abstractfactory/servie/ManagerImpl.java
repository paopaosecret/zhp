package com.xander.designpattern.createtype.factory.abstractfactory.servie;

import com.xander.designpattern.createtype.factory.abstractfactory.contract.IManager;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class ManagerImpl implements IManager {
    @Override
    public void show() {
        System.out.println("I am manager");
    }
}

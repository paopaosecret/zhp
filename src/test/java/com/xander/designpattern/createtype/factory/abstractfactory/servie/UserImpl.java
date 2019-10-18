package com.xander.designpattern.createtype.factory.abstractfactory.servie;

import com.xander.designpattern.createtype.factory.abstractfactory.contract.IUser;

/**
 * Created by zhaobing04 on 2019/10/17.
 */
public class UserImpl implements IUser {

    @Override
    public void show() {
        System.out.println("my name is zhangsan");
    }
}

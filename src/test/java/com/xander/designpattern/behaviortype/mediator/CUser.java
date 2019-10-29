package com.xander.designpattern.behaviortype.mediator;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 具体同事类C
 */
public class CUser implements User{
    @Override
    public void showMessage(String msg) {
        System.out.println("C " + msg + "\n");
    }
}

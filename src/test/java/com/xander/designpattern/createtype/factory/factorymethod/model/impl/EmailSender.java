package com.xander.designpattern.createtype.factory.factorymethod.model.impl;


import com.xander.designpattern.createtype.factory.factorymethod.model.Sender;

/**
 * Created by bing.zhao on 2016/11/30.
 */

public class EmailSender implements Sender {
    @Override
    public void send() {
        System.out.println("EmailSender -> send");
    }
}

package com.xander.spi;

import java.util.ServiceLoader;

/**
 * Created by zhaobing04 on 2019/8/29.
 */
public class SPIMain {
    public static void main(String args[]){
        ServiceLoader<IFruit> fruits = ServiceLoader.load(IFruit.class);
        for(IFruit fruit : fruits){
            fruit.name();
        }
    }
}

package com.xander.designpattern.behaviortype.strategy;

/**
 * Created by zhaobing04 on 2019/4/10.
 */
public class BusStrategy implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("使用公共汽车");
    }
}

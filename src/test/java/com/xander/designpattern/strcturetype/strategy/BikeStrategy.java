package com.xander.designpattern.strcturetype.strategy;

/**
 * Created by zhaobing04 on 2019/4/10.
 */
public class BikeStrategy implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("使用自行车");
    }
}

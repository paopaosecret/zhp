package com.xander.designpattern.behaviortype.strategy;

/**
 * Created by zhaobing04 on 2019/4/10.
 * 具体的算法
 */
public class ZheKouStrategy implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("现在商品打八折");
    }
}

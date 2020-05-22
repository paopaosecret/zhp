package com.xander.designpattern.behaviortype.strategy;

/**
 * Created by zhaobing04 on 2019/4/10.
 * 具体的算法
 */
public class MaiSongStrategy implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("买一件送一件");
    }
}

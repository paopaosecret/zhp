package com.xander.designpattern.behaviortype.strategy;

/**
 * Created by zhaobing04 on 2019/4/10.
 */
public class StrategyPattern {

    public static void main(String args[]){
        Context context = new Context();
        Strategy s = new BusStrategy();
        context.setStrategy(s);
        context.exeStrategy();
    }
}

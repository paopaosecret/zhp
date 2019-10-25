package com.xander.designpattern.behaviortype.strategy;

/**
 * Created by zhaobing04 on 2019/4/10.
 * 环境类：使用算法的客户
 */
public class Context {

    private Strategy  strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void exeStrategy(){
        if(strategy == null){
            System.out.println("请先设置策略");
        }
        strategy.strategyMethod();
    }
}

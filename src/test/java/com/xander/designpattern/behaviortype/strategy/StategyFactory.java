package com.xander.designpattern.behaviortype.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaobing04 on 2019/4/10.
 *
 * 策略模式扩展   策略很多时，可以使用策略工厂
 */
public class StategyFactory {

    Map<String, Strategy> strategyMap = new HashMap<>();

    public void put(String key, Strategy strategy){
        strategyMap.put(key,strategy);
    }

    public Strategy get(String key){
        return strategyMap.get(key);
    }

    public void exeStrategy(String key){
        if(strategyMap.get(key) == null){
            System.out.println(key + "该策略不存在");
        }
        strategyMap.get(key).strategyMethod();
    }
}

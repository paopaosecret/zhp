package com.xander.designpattern.strcturetype.flyweight;

import java.util.HashMap;

/**
 * Created by zhaobing04 on 2019/10/23.
 */
public class FlyweightFactory {
    //定义一个池容器
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    //享元工厂，根据外部状态获取
    public static Flyweight getFlyweight(String extrinsic){
        Flyweight flyweight = null;
        if(pool.containsKey(extrinsic)){
            flyweight = pool.get(extrinsic);
            System.out.println("已有 " + extrinsic + " 直接从池中取出----");
        }else{
            flyweight = new ConcreteFlyweight(extrinsic);
            pool.put(extrinsic, flyweight);
            System.out.println("创建 " + extrinsic + " 并从池子中取出----");
        }
        return flyweight;
    }
}

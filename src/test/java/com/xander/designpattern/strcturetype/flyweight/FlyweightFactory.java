package com.xander.designpattern.strcturetype.flyweight;

import java.util.HashMap;

/**
 * Created by zhaobing04 on 2019/10/23.
 */
public class FlyweightFactory {
    //定义一个池容器
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    //享元工厂，根据外部状态获取
    public static Flyweight getFlyweight(String intrinsic){
        Flyweight flyweight = null;
        if(pool.containsKey(intrinsic)){
            flyweight = pool.get(intrinsic);
            System.out.println("已有 " + intrinsic + " 直接从池中取出----");
        }else{
            if(intrinsic.contains("white")){
                flyweight = new WhiteConcreteFlyweight(intrinsic);
            }else if(intrinsic.contains("black")){
                flyweight = new BlackConcreteFlyweight(intrinsic);
            }
            pool.put(intrinsic, flyweight);
            System.out.println("创建 " + intrinsic + " 并从池子中取出----");
        }
        return flyweight;
    }
}

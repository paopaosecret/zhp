package com.xander.designpattern.behaviortype.strategy;

import java.util.Random;

/**
 * Created by zhaobing04 on 2019/4/10.
 * 策略（Strategy）模式的定义:该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换
 * 且算法的变化不会影响使用算法的客户，通过对算法的封装，把使用算法的责任和算法的实现分割开来
 *
 */
public class Note {

    public static void main(String args[]){
        Context context = null;

        for(int i= 0 ; i< 10;i++){
            int type = new Random().nextInt(2);
            switch (type){
                case 0:
                    context = new Context(new BusStrategy());
                    break;
                case 1:
                    context = new Context(new BikeStrategy());
                    break;
            }
            context.exeStrategy();
        }
    }
}

package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2020/7/20.
 */
public class BlackConcreteFlyweight extends Flyweight {

    public BlackConcreteFlyweight(String intrinsic) {
        super(intrinsic);
    }

    @Override
    public void operation(int extrinsic) {
        System.out.println("内部状态：" + getIntrinsic());
        System.out.println("外部状态： 处理白子落子后的逻辑:" + extrinsic);
    }
}

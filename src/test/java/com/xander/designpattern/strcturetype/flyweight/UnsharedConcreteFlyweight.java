package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2019/10/23.
 *
 * 指那些不需要共享的Flyweight子类。
 */
public class UnsharedConcreteFlyweight extends Flyweight{

    public UnsharedConcreteFlyweight(String extrinsic){
        super(extrinsic);
    }

    @Override
    public void operation(int extrinsic) {
        System.out.println("不共享具体的Flyweight:" + extrinsic);
    }

}

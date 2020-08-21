package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2019/10/23.
 *
 * 继承Flyweight超类或实现Flyweight接口，并为其内部状态增加存储空间。
 */
public class WhiteConcreteFlyweight extends Flyweight{

    public WhiteConcreteFlyweight(String intrinsic){
        super(intrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operation(int extrinsic) {
        System.out.println("内部状态：" + getIntrinsic());
        System.out.println("外部状态： 处理白子落子后的逻辑:" + extrinsic);
    }
}

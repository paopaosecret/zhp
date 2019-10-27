package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2019/10/23.
 *
 * 继承Flyweight超类或实现Flyweight接口，并为其内部状态增加存储空间。
 */
public class ConcreteFlyweight extends Flyweight{

    //接收外部状态
    public ConcreteFlyweight(String extrinsic){
        super(extrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operation(int extrinsic) {
        System.out.println("具体的Flyweight:" + extrinsic);
    }
}

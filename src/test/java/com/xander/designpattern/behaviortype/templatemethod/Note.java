package com.xander.designpattern.behaviortype.templatemethod;

/**
 * Created by zhaobing04 on 2019/10/25.
 * 模板方法模式定义：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，
 * 使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。它是一种类行为型模式。
 *
 * 联想之前只能插座绑定流程作参考。
 */
public class Note {

    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}

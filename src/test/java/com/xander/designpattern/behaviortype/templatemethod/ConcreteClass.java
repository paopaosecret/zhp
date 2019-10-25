package com.xander.designpattern.behaviortype.templatemethod;

/**
 * Created by zhaobing04 on 2019/10/25.
 */
public class ConcreteClass extends AbstractClass {

    @Override
    public void absFristStep() {
        System.out.println("实现抽象第一步");
    }

    @Override
    public void absSecondStep() {
        System.out.println("实现抽象第二步");
    }
}

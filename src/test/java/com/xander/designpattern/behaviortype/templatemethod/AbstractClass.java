package com.xander.designpattern.behaviortype.templatemethod;

/**
 * Created by zhaobing04 on 2019/10/25.
 */
public abstract class AbstractClass {

    /**
     * 定义具体流程
     */
    public void templateMethod(){
        specificMethod();
        absFristStep();
        absSecondStep();
    }

    /**
     * 具体方法,流程中的步骤
     */
    public void specificMethod(){
        System.out.println("执行某个具体操作");
    }

    /**
     * 抽象第一步,流程中的步骤
     */
    public abstract void absFristStep();

    /**
     * 抽象第二步,流程中的步骤
     */
    public abstract void absSecondStep();

}

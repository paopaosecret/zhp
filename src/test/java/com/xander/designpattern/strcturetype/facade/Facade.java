package com.xander.designpattern.strcturetype.facade;

/**
 * Created by zhaobing04 on 2019/10/23.
 */
public class Facade {
    private ASystem aSystem;
    private BSystem bSystem;
    private CSystem cSystem;

    public Facade(){
        aSystem = new ASystem();
        bSystem = new BSystem();
        cSystem = new CSystem();
    }

    public void methodA(){
        aSystem.methodA();
    }

    public void methodB(){
        bSystem.methodB();
    }

    public void methodC(){
        cSystem.methodC();
    }
}

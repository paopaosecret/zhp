package com.xander.designpattern.behaviortype.dutychain;

/**
 * Created by zhaobing04 on 2020/5/22.
 */
public class Chain {
    private Handler h1, h2, h3;


    /**
     * 初始数字的责任链
     *
     */
    public Chain(){
        h1 = new HandlerImp1();
        h2 = new HandlerImp2();
        h3 = new HandlerImp3();
        h1.setNextHandler(h2);
        h2.setNextHandler(h3);
    }

    public void process(int request){
        h1.handlerRequest(request);
    }
}

package com.xander.designpattern.behaviortype.dutychain;

/**
 * Created by zhaobing04 on 2018/3/17.
 */

public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    abstract void handlerRequest(int request);
}

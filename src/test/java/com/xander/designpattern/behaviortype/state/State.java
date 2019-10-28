package com.xander.designpattern.behaviortype.state;

/**
 * Created by zhaobing04 on 2019/10/28.
 *
 * 抽象状态类：不同的状态对当前的环境进行不同的处理
 */
public abstract class State {
    public abstract void handle(ViewContext context);
}

package com.xander.designpattern.behaviortype.memento;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 备忘录角色:负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 */
public class Memento {

    private String state;
    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

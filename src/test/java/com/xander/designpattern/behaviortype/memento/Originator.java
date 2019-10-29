package com.xander.designpattern.behaviortype.memento;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 发起人角色:记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，
 *              实现其他业务功能，它可以访问备忘录里的所有信息。
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void restoreMemento(Memento memento){
        this.setState(memento.getState());
    }

}

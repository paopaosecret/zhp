package com.xander.designpattern.behaviortype.state;

/**
 * Created by zhaobing04 on 2019/10/28.
 * View充当环境，三个状态Measure/Layout/Draw
 *
 * 具体的环境类   也称为上下文，它定义了客户感兴趣的接口，维
 * 护一个当前状态，并将与状态相关的操作委托给当前状态对象来处理。
 */
public class ViewContext {
    private State state;

    public ViewContext(){
        state = new MeasureState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle(){
        state.handle(this);
    }
}

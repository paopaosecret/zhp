package com.xander.designpattern.behaviortype.state;

/**
 * Created by zhaobing04 on 2019/10/28.
 *
 * 具体的某个状态，对当前环境做具体的绘制操作
 */
public class DrawState extends State{
    @Override
    public void handle(ViewContext context) {
        System.out.println("View 绘制中");
//        context.setState(new DrawState());  //循环状态的情况可设置为之前的状态
    }
}

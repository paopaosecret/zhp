package com.xander.designpattern.behaviortype.state;

/**
 * Created by zhaobing04 on 2019/10/28.
 *
 * 具体的某个状态，对当前环境做具体的布局操作
 */
public class LayoutState extends State{
    @Override
    public void handle(ViewContext context) {
        System.out.println("View 布局中");
        context.setState(new DrawState());
    }
}

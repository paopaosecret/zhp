package com.xander.designpattern.behaviortype.state;

/**
 * Created by zhaobing04 on 2019/10/28.
 *
 * 具体的某个状态，对当前环境做具体的测量操作
 */
public class MeasureState extends State {

    @Override
    public void handle(ViewContext context) {
        System.out.println("View 测量中");
        context.setState(new LayoutState());
    }
}

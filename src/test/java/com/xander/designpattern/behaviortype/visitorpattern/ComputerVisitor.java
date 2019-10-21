package com.xander.designpattern.behaviortype.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public interface ComputerVisitor {
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

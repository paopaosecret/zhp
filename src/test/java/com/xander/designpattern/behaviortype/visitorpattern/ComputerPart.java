package com.xander.designpattern.behaviortype.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public interface ComputerPart {
    void accept(ComputerVisitor visitor);
}

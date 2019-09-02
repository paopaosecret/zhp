package com.xander.designpattern.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public interface ComputerPart {
    void accept(ComputerVisitor visitor);
}

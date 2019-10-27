package com.xander.designpattern.behaviortype.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }

    public String operationMonitor(){
        return "操作显示器";
    }
}

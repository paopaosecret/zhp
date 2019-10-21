package com.xander.designpattern.behaviortype.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }

    public String operationMouse(){
        return "操作鼠标";
    }
}

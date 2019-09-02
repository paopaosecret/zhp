package com.xander.designpattern.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }

    public String operationKeyboard(){
        return "操作键盘";
    }
}

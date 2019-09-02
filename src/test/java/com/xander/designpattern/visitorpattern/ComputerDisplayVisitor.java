package com.xander.designpattern.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class ComputerDisplayVisitor implements ComputerVisitor{

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Display Mouse " + mouse.operationMouse());
    }

    @Override
    public void visit(Keyboard keyboard) {

        System.out.println("Display Keyboard " +  keyboard.operationKeyboard());
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Display Monitor " + monitor.operationMonitor());
    }
}

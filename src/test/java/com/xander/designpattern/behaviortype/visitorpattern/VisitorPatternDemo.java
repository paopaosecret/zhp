package com.xander.designpattern.behaviortype.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 */
public class VisitorPatternDemo {

    public static void main(String args[]){
        Computer computer = new Computer();
        computer.add(new Mouse());
        computer.add(new Monitor());
        computer.add(new Keyboard());

        computer.accept(new ComputerDisplayVisitor());
    }
}

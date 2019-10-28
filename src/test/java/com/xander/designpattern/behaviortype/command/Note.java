package com.xander.designpattern.behaviortype.command;

/**
 * Created by zhaobing04 on 2019/10/28.
 *
 * 命令（Command）模式：将一个请求封装成一个对象，使发出请求的责任和执行请求的的责任分开。
 * 两者之间通过命令对象进行沟通，这样方便将命令对象，储存、传递、调用、增加和管理
 *
 *  抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
 *  具体命令角色（Concrete    Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，
                                                并通过调用接收者的功能来完成命令要执行的操作。
 *  实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
 *  调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，
                                                并通过访问命令对象来执行相关请求，它不直接访问接收者。
 *  Note类相当于一个Client端
 */
public class Note {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        EchoCommand command = new EchoCommand(new EchoReceiver());
        command.setText("hello word");
        invoker.setCommand(command);

        invoker.execCommand();
    }
}

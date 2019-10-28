package com.xander.designpattern.behaviortype.command;

/**
 * Created by zhaobing04 on 2019/10/28.
 * 抽象命令类的具体实现类：(一般系统中会具有一个或者多个具体的命令实现类)
 * 相当于okhttp的ReadCall类
 *
 * 1.它拥有接收者对象
 * 2.通过调用接收者的功能来完成命令要执行的操作。
 */
public class EchoCommand implements ICommand{

    /**
     *  1.它拥有接收者对象,通过调用接收者的功能来完成命令要执行的操作。
     */
    private EchoReceiver mEchoReceiver;

    /**
     * 请求对象封装的数据
     */
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public EchoCommand(EchoReceiver receiver){
        this.mEchoReceiver = receiver;
    }


    @Override
    public void execute() {
        mEchoReceiver.echo(text);
    }
}

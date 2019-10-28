package com.xander.designpattern.behaviortype.command;

/**
 * Created by zhaobing04 on 2019/10/28.
 * 接受者对象，真正执行命令的对象。
 * 相当于Okhttp的Dispatcher类
 */
public class EchoReceiver {
    /**
     * 执行echo命令
     * @param text
     */
    public void echo(String text){
        System.out.println(text);
    }
}

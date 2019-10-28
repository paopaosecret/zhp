package com.xander.designpattern.behaviortype.command;

/**
 * Created by zhaobing04 on 2019/10/28.
 * 抽象命令类（Command）角色:相当于Okhttp 的Call类
 */
public interface ICommand {

    /**
     * 声明执行命令的接口，拥有执行命令的抽象方法 execute()。
     */
    void execute();
}

package com.xander.designpattern.behaviortype.mediator;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 抽象中介类
 */
public interface QQ {
    /**
     * 向用户容器中添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 一对一发送消息
     * @param from
     * @param to
     * @param msg
     */
    void sendMessage(User from, User to, String msg);

    /**
     * 向全部用户发送消息
     * @param from
     * @param msg
     */
    void sendAll(User from, String msg);
}

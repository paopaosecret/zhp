package com.xander.designpattern.behaviortype.mediator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 具体的中介对象
 */
public class QQManager implements QQ{
    /**
     * 用户容器
     */
    Set<User> userSet = new HashSet<>();

    @Override
    public void addUser(User user) {
        userSet.add(user);
    }

    @Override
    public void sendMessage(User from, User to, String msg) {
        from.showMessage("发送" + msg + "成功！");
        to.showMessage("接收" + msg + "成功！");
    }

    @Override
    public void sendAll(User from, String msg) {
        if(!userSet.contains(from)){
            userSet.add(from);
        }
        from.showMessage("发送" + msg + "成功！");
        for(User to : userSet){
            to.showMessage("接收" + msg + "成功！");
        }
    }
}

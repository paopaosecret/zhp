package com.xander.designpattern.behaviortype.state;

import com.xander.designpattern.strcturetype.adapter.View;

/**
 * Created by zhaobing04 on 2019/10/28.
 * 状态（State）模式:对有状态的对象，把复杂的“判断逻辑”提取到不同状态对象中，允许状态对象在其内部状态发生改变时
 *                   改变行为
 *
 * 环境（Context）角色：也称为上下文，它定义了客户感兴趣的接口，维护一个当前状态，
 *                      并将与状态相关的操作委托给当前状态对象来处理。
 * 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为
 * 具体状态（Concrete    State）角色：实现抽象状态所对应的行为。
 *
 */
public class Note {
    public static void main(String[] args) {
        ViewContext context = new ViewContext();
        context.handle();
        context.handle();
        context.handle();
    }
}

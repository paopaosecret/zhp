package com.xander.designpattern.strcturetype.decorator;

/**
 * Created by zhaobing04 on 2018/4/23.
 *
 * 抽象装饰 集成抽象构建，并持有具体构建
 */

public class Decorator implements Show {
    protected Show mBase;
    public Decorator(Show show){
        mBase = show;
    }

    @Override
    public void show() {
        this.mBase.show();
    }
}

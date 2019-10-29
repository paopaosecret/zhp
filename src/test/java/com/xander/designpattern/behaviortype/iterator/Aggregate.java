package com.xander.designpattern.behaviortype.iterator;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 抽象聚合类
 */
public interface Aggregate {

    void add(Object obj);
    void remove(Object obj);
    Iterator getIterator();
}

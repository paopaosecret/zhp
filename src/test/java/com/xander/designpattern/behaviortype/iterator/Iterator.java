package com.xander.designpattern.behaviortype.iterator;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 抽象迭代器
 */
public interface Iterator {
    Object frist();
    Object next();
    boolean hasNext();
}

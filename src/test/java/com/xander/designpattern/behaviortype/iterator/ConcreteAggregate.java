package com.xander.designpattern.behaviortype.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/10/29.
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}

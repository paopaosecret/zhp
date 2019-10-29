package com.xander.designpattern.behaviortype.iterator;

import java.util.List;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 具体迭代器类
 */
public class ConcreteIterator implements Iterator{
    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list){
        this.list = list;
    }

    @Override
    public Object frist() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }

    @Override
    public Object next() {
        Object obj = null;
        if(this.hasNext()){
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if(index < list.size() - 1){
            return true;
        }
        return false;
    }
}

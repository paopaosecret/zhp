package com.xander.designpattern.behaviortype.iterator;

/**
 * Created by zhaobing04 on 2019/10/29.
 *
 * 迭代器(Iterator)模式：提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示
 *
 * 模式的结构：
 * 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合对象以及创建迭代器对象的接口。
 * 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
 * 抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法。
 * 具体迭代器（Concretelterator）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置。
 *
 *
 */
public class Note {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("zhangsan");
        aggregate.add("lisi");
        aggregate.add("wangwu");

        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        Object frist = iterator.frist();
        System.out.println("第一个元素：" + frist.toString());
    }
}

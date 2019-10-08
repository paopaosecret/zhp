package com.xander.designpattern.prototype;

import java.util.Random;

/**
 * Created by zhaobing04 on 2019/9/30.
 *
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 *
 * 由于 Java 提供了对象的 clone() 方法，所以用 Java 实现原型模式很简单。
 */
public class Circle implements Cloneable {

    private int r = 1;

    public Object clone(){
        r = new Random().nextInt(100) + 1;
        System.out.println("克隆了一个圆,半径：" + r);
        try {
            return (Circle)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void calcArea(){
        System.out.println("该圆的面积="+3.1415*r*r+"\n");
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.calcArea();

        Circle circle1 = (Circle) circle.clone();
        circle1.calcArea();

        Circle circle2 = (Circle) circle1.clone();
        circle2.calcArea();
    }

}

package com.xander.designpattern.createtype.prototype;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhaobing04 on 2019/9/30.
 *
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 * 1. 模式的结构
 * 原型模式包含以下主要角色。
 * 抽象原型类：规定了具体原型对象必须实现的接口，由于 Java 提供了对象的 clone() 方法，可实现Cloneable接口（Cloneable接口充当抽象原型类角色），使用的是浅克隆的方式
 * 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象（CircleQianClone 充当此角色）。
 * 访问类：使用具体原型类中的 clone() 方法来复制新的对象，例子中的main()方法充当此角色
 *
 *
 * 深克隆 和 浅克隆
 *
 * 浅克隆{@link CircleQianClone}：重新开辟一块内存空间，将之前对象中属性的值复制过去。如果是普通字段和字符串，则正常，如果是应用对象，指向的还是之前对象的属性引用
 * 深克隆{@link CircleShenClone}：需要在clone()方法中递归克隆每一个对象属性的clone方法,前提是子类必须支持clone（)方式
 */
public class CircleQianClone implements Cloneable {

    private int r;

    private Dot dot;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Dot getDot() {
        return dot;
    }

    public void setDot(Dot dot) {
        this.dot = dot;
    }

    /**
     * Object 类的方法
     * @return
     */
    @Override
    public Object clone(){
        try {
            return (CircleQianClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        CircleQianClone circle = new CircleQianClone();
        circle.setDot(new Dot(0,0));
        System.out.println("circle dot:" + JSON.toJSONString(circle));

        CircleQianClone circle1 = (CircleQianClone) circle.clone();
        circle1.getDot().setX(2);
        circle1.getDot().setY(2);
        circle1.setR(2);

        System.out.println("circle dot:" + JSON.toJSONString(circle));
        System.out.println("circle1 dot:" + JSON.toJSONString(circle1));
    }

}

package com.xander.designpattern.behaviortype.visitorpattern;

/**
 * Created by zhaobing04 on 2019/7/11.
 * 访问者（Visitor）模式的定义：将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，
 *      使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。
 *      它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。
 *
 * 模式结构：
 * 抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
 * 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
 * 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
 * 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 * 对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 *
 * 生活实例：
 * 医院医生开的处方单中包含多种药元素，査看它的划价员和药房工作人员对它的处理方式也不同，
 * 划价员根据处方单上面的药品名和数量进行划价，药房工作人员根据处方单的内容进行抓药。

 * 还有顾客在商场购物时放在“购物车”中的商品，顾客主要关心所选商品的性价比，
 * 而收银员关心的是商品的价格和数量。
 *
 * 代码应用：ASM框架
 */
public class Note {

    public static void main(String args[]){
        Computer computer = new Computer();
        computer.add(new Mouse());
        computer.add(new Monitor());
        computer.add(new Keyboard());

        computer.accept(new ComputerDisplayVisitor());
    }
}

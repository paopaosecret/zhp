package com.xander.designpattern.strcturetype.composite;

/**
 * Created by zhaobing04 on 2019/10/24.
 * 组合（Composite）模式定义：它是一种将对象组合成树状的层次结构的模式，
 * 使得客户以一致的方式处理单个对象以及对象的组合
 *
 * 组合模式实现的最关键的地方是——简单对象和复合对象必须实现相同的接口。
 * 这就是组合模式能够将组合对象和简单对象进行一致处理的原因
 *
 * 如Android 中的View架构
 * 组合部件（Component）：它是一个抽象角色，为要组合的对象提供统一的接口.{ViewManager/ViewParent : 定义了控制子类的方法}
 * 叶子（Leaf）：在组合中表示子节点对象，叶子节点不能有子节点。{如android中的View}
 * 合成部件（Composite）：定义有枝节点的行为，用来存储部件，{如Android中的ViewGroup}
 * 实现在Component接口中的有关操作，如增加（Add）和删除（Remove）。
 *
 * 优点：
 * 1、组合模式可以以层次结构清楚的定义复杂对象。让高层次忽略层次差异。
 * 2、高层次可以使用统一的方法而不用担心它是枝干还是叶子。比如ViewGroup的dispatchView
 * 3、组合模式可以形成复杂的树形结构，但对树形机构的控制却非常简单。
 */
public class Note {
    public static void main(String[] args) {
        System.load("");
        System.out.println("Hello word");
    }
}

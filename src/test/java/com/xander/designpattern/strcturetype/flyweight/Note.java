package com.xander.designpattern.strcturetype.flyweight;

/**
 * Created by zhaobing04 on 2019/10/23.
 * 享元模式（Flyweight），运用共享技术有效地支持大量细粒度的对象。
 *
 * 享元模式，第一个想到的应该就是池技术了，String常量池、数据库连接池、
 * 缓冲池等等都是享元模式的应用，所以说享元模式是池技术的重要实现方式。
 *
 * 我们举一个最简单的例子，棋牌类游戏大家都有玩过吧，比如说说围棋和跳棋，
 * 它们都有大量的棋子对象，围棋和五子棋只有黑白两色，跳棋颜色略多一点，
 * 但也是不太变化的，所以棋子颜色就是棋子的内部状态；而各个棋子之间的差别就是位置的不同，
 * 我们落子嘛，落子颜色是定的，但位置是变化的，所以方位坐标就是棋子的外部状态。
 *
 * 那么为什么这里要用享元模式呢？可以想象一下，上面提到的棋类游戏的例子，
 * 比如围棋，理论上有361个空位可以放棋子，常规情况下每盘棋都有可能有两三百个棋子对象产生，
 * 因为内存空间有限，一台服务器很难支持更多的玩家玩围棋游戏，如果用享元模式来处理棋子，
 * 那么棋子对象就可以减少到只有两个实例，这样就很好的解决了对象的开销问题。
 *
 * 根据位置获取到棋子如果是白色的  就直接在棋盘显示白棋
 * 根据位置获取到棋子如果是黑色的  就直接在棋盘显示黑棋
 * 所以内容中只需要有两个棋子对象，不同的位置指向的都是这两个对象
 */
public class Note {
    public static void main(String[] args) {
        int extrinsic = 22;

        Flyweight flyweightX = FlyweightFactory.getFlyweight("X");
        flyweightX.operation(++ extrinsic);

        Flyweight flyweightY = FlyweightFactory.getFlyweight("Y");
        flyweightY.operation(++ extrinsic);

        Flyweight flyweightZ = FlyweightFactory.getFlyweight("Z");
        flyweightZ.operation(++ extrinsic);

        Flyweight flyweightRX = FlyweightFactory.getFlyweight("X");
        flyweightRX.operation(++ extrinsic);

        Flyweight flyweight = new UnsharedConcreteFlyweight("X");
        flyweight.operation(++ extrinsic);
    }
}

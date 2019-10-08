package com.xander.designpattern.Singleton;


/**
 * Created by bing.zhao on 2016/11/30.
 *
 * 单例模式的懒汉实现5--线程安全
 * 通过设置同步代码块，使用DCL双检查锁机制
 * 使用双检查锁机制成功的解决了单例模式的懒汉实现的线程不安全问题和效率问题
 * DCL也是大多数多线程结合单例模式使用的解决方案
 * 问题1：两个if的作用
 *
 * 第一个if判断的作用：是为了提高程序的 效率，当SingletonLazy5对象被创建以后，再获取SingletonLazy5对象时就不用去验证同步代码块的锁及后面的代码，直接返回SingletonLazy5对象
 * 第二个if判断的作用：是为了解决多线程下的安全性问题，也就是保证对象的唯一。
 *
 * 问题2：使用了synchronized关键字 为什么还需要使用volatile关键字修饰该对象？
 *
 * 原因：如果线程A已经执行到instance = new Singleton(); 其中new Singleton()非原子性，其中包含的步骤
 * 1.申请一个内存区域（空白内存）2.调用构造方法等对singleton进行初始化（写内存）3.将变量指针指向该对象内存区域（变量声明）
 * 如果不加volatile ,则编译器有可能进行指令重排 第3步提到了第二步之前  然后当执行3时，该单例对象还没有初始化完成 线程B开始访问
 * 此方法，获取到引用不为null ,就去使用此对象，由于该对象没有初始化，所以会使用不完整的对象，所以要加此关键字
 */
public class Singleton {

    /**
     * 1.构造器私有化，不允许别人new实例
     */
    private Singleton(){
    }

    /**
     * 2.声明一个公外部调用的单例
     */
    private volatile static Singleton instance;

    /**
     * 3.实现上述单例
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {       //保证线程安全
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

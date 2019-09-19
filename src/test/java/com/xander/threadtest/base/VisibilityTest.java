package com.xander.threadtest.base;

/**
 * Created by zhaobing04 on 2019/9/18.
 * 可见性测试
 */
public class VisibilityTest {

    /**
     * 多个线程访问此变量  单个线程修改其值，别的线程不可见而导致异常
     *
     * 如果需要在多个线程可见，可添加volatile关键字
     */
    public static boolean stop;

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " thread start");
            while(!stop);
            System.out.println(Thread.currentThread().getName() + " thread end");
        },"t1").start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " thread start");
            stop = true;
            System.out.println(Thread.currentThread().getName() + " thread end");
        },"t2").start();
    }

}

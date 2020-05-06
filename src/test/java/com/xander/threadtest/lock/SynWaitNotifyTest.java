package com.xander.threadtest.lock;

/**
 * Created by Administrator on 2019/9/16.
 * 交替打印两个字符串
 *
 */
public class SynWaitNotifyTest {

    public static void main(String args[]){
        final Object o = new Object();

        char[] aI = "1234567".toCharArray();
        char[] aC = "abcdefg".toCharArray();

        new Thread(()->{
            for(char c:aI){
                System.out.print(c);
                try {
                    synchronized (o){
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            for(char c:aC){
                System.out.print(c);
                try {
                    synchronized (o){
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}

package com.xander.threadtest.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaobing04 on 2020/4/29.
 * ReentrantLock:重入锁，发生异常时，不会释放锁，需要手动释放
 * 默认情况下，synchronized 和 ReentrantLock 都是非公平锁。
 * 但是 ReentrantLock 可以通过传入 true 来创建一个公平锁。
 * 所谓公平锁：就是通过同步队列来实现多个线程按照申请锁的顺序获取锁
 */
public class ReentrantLockTest {
    int count;
    /**
     * true: 公平锁
     * 默认：false 非公平锁
     */
    ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        new ReentrantLockTest().testLock(20,10000);
    }

    void lock(ReentrantLockTest test){
        lock.lock();
        try {
            test.count++;
        }finally {
            lock.unlock();
        }

    }

    /**
     * 测试使用lock方式处理同步
     * @param threadNum  线程个数
     * @param loopNum 每个线程循环加的次数
     */
    public void testLock(int threadNum, int loopNum){
        ReentrantLockTest test= new ReentrantLockTest();
        Thread[] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    for(int i = 0; i < loopNum; i++){
                        test.lock(test);
                    }
                }
            });
            threads[i].start();

            /**
             *  //如果在此处加入join（）代码，主线程会等待一个线程执行完之后再去启动下一个线程，所以怎样结果都是正确的
             */
//            try {
//                //等待此线程结束后才执行,不然主线程结束了，还有很多子线程没运行完，导致结果异常
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        for(int i = 0; i < threadNum; i++){
            try {
                //等待此线程结束后才执行,不然主线程结束了，还有很多子线程没运行完，导致结果异常
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("count = " +   test.count);
    }
}

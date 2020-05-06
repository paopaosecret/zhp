package com.xander.threadtest.lock;

/**
 * Created by zhaobing04 on 2020/4/29.
 * 修饰静态方法   -》 锁类对象
 * 修饰实例方法   -》 锁实例对象
 * 修饰代码块     -》 需要一个锁对象
 *
 * Synchronized:发生异常时，会自动释放锁
 */
public class SynchronizedTest {
    int count;
    Object lock = new Object();
    /**
     * 修饰静态方法
     */
    public synchronized static void addS(SynchronizedTest test){
        test.count++;
    }

    /**
     * 修饰实例方法
     */
    public synchronized void addM(SynchronizedTest test){
        test.count++;
    }

    /**
     * 修饰代码块
     */
    public void add(SynchronizedTest test){
        synchronized (lock){
            test.count++;
        }
    }

    public static void main(String[] args) {
        new SynchronizedTest().testAdds(20, 100000);
        new SynchronizedTest().testAddm(20, 100000);
        new SynchronizedTest().testAdd(20, 100000);
    }

    /**
     * 测试修饰静态方法
     * @param threadNum  线程个数
     * @param loopNum 每个线程循环加的次数
     */
    public void testAdds(int threadNum, int loopNum){
        SynchronizedTest test= new SynchronizedTest();
        Thread[] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < loopNum; i++){
                        SynchronizedTest.addS(test);
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

    /**
     * 测试修饰实例方法
     * @param threadNum  线程个数
     * @param loopNum 每个线程循环加的次数
     */
    public void testAddm(int threadNum, int loopNum){
        SynchronizedTest test= new SynchronizedTest();
        Thread[] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < loopNum; i++){
                        test.addM(test);
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

    /**
     * 测试修饰代码块
     * @param threadNum  线程个数
     * @param loopNum 每个线程循环加的次数
     */
    public void testAdd(int threadNum, int loopNum){
        SynchronizedTest test= new SynchronizedTest();
        Thread[] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < loopNum; i++){
                        test.add(test);
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

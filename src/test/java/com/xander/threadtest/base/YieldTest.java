package com.xander.threadtest.base;

/**
 * Created by zhaobing04 on 2019/9/27.
 * Thread.yield()方法：将当前线程从运行态转为就绪态，重新去竞争cpu资源
 */
public class YieldTest {
    private static final int DEST_NUM = 200;

    public static void main(String[] args) {
        new YieldTest();
    }

    public YieldTest(){

        ThreadDemo yt1 = new ThreadDemo("张三");
        ThreadDemo yt2 = new ThreadDemo("李四");
        ThreadDemo yt3 = new ThreadDemo("王五");
//        ThreadDemo yt4 = new ThreadDemo("刘六");
//        ThreadDemo yt5 = new ThreadDemo("赵七");

        //yt1.setPriority(10);
        //yt1.setPriority(5);
        //yt3.setPriority(1);

        yt1.start();
        yt2.start();
        yt3.start();
//        yt4.start();
//        yt5.start();

    }

    public class ThreadDemo extends Thread{

        public ThreadDemo(String name){
            setName(name);
        }

        @Override public void run() {

            for (int i = 1; i <= DEST_NUM; i++) {

                // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
                if (i % 5 == 0) {
                    System.out.println("" + this.getName() + "-----" + i + "    yeild一下");
                    yield();
                    System.out.println("" + this.getName() + "-----" + i);
                }else{
                    System.out.println("" + this.getName() + "-----" + i);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}

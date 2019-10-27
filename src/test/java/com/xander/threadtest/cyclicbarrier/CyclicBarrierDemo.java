package com.xander.threadtest.cyclicbarrier;

import com.xander.threadtest.countdownlatch.ThreadPoolUtil;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 1、定义栅栏  以及栅栏成员有五个
         * 2、如果这5个成员在五个线程中运行   只有每一个都调用了barrier.await（）方法
         * 3、这个成员线程才会执行await()方法之后的代码
         * Cyclic  英 [ˈsaɪklɪk]   美 [ˈsaɪklɪk]
         * Barrier 英 [ˈbæriə(r)]   美 [ˈbæriər]
         */
        int parties = 5;   //，
        final CyclicBarrier barrier = new CyclicBarrier(parties);

        for(int i=0; i<parties; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {

                    try {
                        int time = new Random().nextInt(5000);
                        System.out.println("thread "+Thread.currentThread().getName()+" 准备去集合");
                        barrier.await();
                        System.out.println("thread "+Thread.currentThread().getName()+" 到达集合点");
                        TimeUnit.MILLISECONDS.sleep(time);
                        barrier.await();    //到达集合点, 数量加1
                        System.out.println("thread "+Thread.currentThread().getName()+" 通过集合点继续往后执行");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };

            ThreadPoolUtil.getIns().inThread(task);
        }
        ThreadPoolUtil.getIns().shutdown();
    }
}

package com.xander.threadtest.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhaobing04 on 2019/8/29.
 * 创建一个带返回值的线程
 */
public class FutureThread {

    public static void main(String args[]){
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable is start");
                Thread.sleep(2000);
                System.out.println("Callable is end");
                return "hello word";
            }
        });

        new Thread(futureTask).start();

        try {
            System.out.println("main thread 1");
            String threadResult = (String)(futureTask.get());
            System.out.println("main thread 2");
            System.out.println(threadResult);
            System.out.println("main thread 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

package com.xander.threadtest.lock;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhaobing04 on 2019/9/19.
 * 生产者和消费者
 * 使用ArrayBlockingQueue作为消息队列
 */
public class SynWaitNotifyTest2 {
    private static ArrayBlockingQueue<String> messages = new ArrayBlockingQueue<String>(10);

    public static class Producer extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (messages){
                    while(messages.size() == 10){
                        messages.notifyAll();
                        System.out.println("当前队列已满");
                        try {
                            messages.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    String message = "消息" + new Random().nextInt(1000000);
                    messages.add(message);
                    messages.notifyAll();
                    System.out.println("生产了一条消息：" + message);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Consumer extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (messages){
                    while (messages.size() == 0){
                        messages.notifyAll();
                        System.out.println("当前队列为空");
                        try {
                            messages.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String message = messages.poll();
                    messages.notifyAll();
                    System.out.println("消费了一条消息：" + message);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer producer1 = new Producer();
        Producer producer2 = new Producer();
        Producer producer3 = new Producer();
        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();
        Consumer consumer3 = new Consumer();
        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}

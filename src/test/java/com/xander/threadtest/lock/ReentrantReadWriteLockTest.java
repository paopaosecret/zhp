package com.xander.threadtest.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhaobing04 on 2020/4/29.
 * 读写锁：写操作开始到结束之间，不能再有其他读操作进来，并且写操作完成之后的更新数据需要对后续的读操作可见
 * 读写锁new ReentrantReadWriteLock();：传true 或者false， 默认false:非公平锁
 * 使用流程
 * 1：创建读写锁ReadWriteLock rwLock = new ReentrantReadWriteLock();
 * 2：从读写锁中获取读锁：ReentrantReadWriteLock.ReadLock readLock = (ReentrantReadWriteLock.ReadLock) rwLock.readLock();
 * 3：从读写锁中获取写锁：ReentrantReadWriteLock.WriteLock writeLock = (ReentrantReadWriteLock.WriteLock) rwLock.writeLock();
 * 4：使用读锁，写锁
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        Thread writer = new Thread(new Writer());
        Thread reader1 = new Thread(new Reader());
        Thread reader2 = new Thread(new Reader());

        writer.start();
        reader1.start();
        reader2.start();

        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }


    }

    static int number = 0;

    static ReadWriteLock rwLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = (ReentrantReadWriteLock.ReadLock) rwLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = (ReentrantReadWriteLock.WriteLock) rwLock.writeLock();

    static class Reader implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 5000; i++){
                try {
                  readLock.lock();
                  System.out.println(Thread.currentThread().getName() + "读--->" + number);

//                  Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                  readLock.unlock();
                }
            }
        }
    }

    static class Writer implements Runnable{
        @Override
        public void run() {
            for(int i = 1; i< 300; i++){
                try {
                    writeLock.lock();
                    number += i;
                    System.out.println(Thread.currentThread().getName() + "写--->" + number);

                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        }
    }

}

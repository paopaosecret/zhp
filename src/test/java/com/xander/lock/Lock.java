package com.xander.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1、锁的种类
 *
 */
public class Lock
{
    Object object = new Object();

    public void testLock(){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        ReentrantReadWriteLock.ReadLock readLock = new ReentrantReadWriteLock.ReadLock();
    }
}

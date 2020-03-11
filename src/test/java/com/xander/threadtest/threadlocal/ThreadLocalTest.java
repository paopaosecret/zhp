package com.xander.threadtest.threadlocal;

/**
 * Created by Administrator on 2017/9/11.
 * ThreadLocal和Synchronized都是为了解决多线程中相同变量的访问冲突问题，不同的点是
 * 两者区别：Synchronized是通过线程等待，牺牲时间来解决访问冲突
 *      ThreadLocal是通过每个线程单独一份存储空间，牺牲空间来解决冲突，并且相比于Synchronized，
 *      ThreadLocal具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不能访问到想要的值。
 * 使用场景：正因为ThreadLocal的线程隔离特性，使他的应用场景相对来说更为特殊一些。
 *      在android中Looper、ActivityThread以及AMS中都用到了ThreadLocal。
 *      当某些数据是以线程为作用域并且不同线程具有不同的数据副本的时候，就可以考虑采用ThreadLocal。
 */

public class ThreadLocalTest {
    private static final Object lock = new Object();

    public static void main(String args[]){
        HolderInteger holderInteger = new HolderInteger(-1);
        holderInteger.setValue(2);
        holderInteger.setHolderInt(4);  //对于client1，client2,client3不起作用，在主线程中设置值，只对主线程起作用

        HolderObject holderObject = new HolderObject(new Data(0, "null"));

        System.out.println("main value = " + holderInteger.getValue() + ", holderInt = " + holderInteger.getHolderInt());

        ThreadClient client1 = new ThreadClient(holderInteger,holderObject);
        ThreadClient client2 = new ThreadClient(holderInteger,holderObject);
        ThreadClient client3 = new ThreadClient(holderInteger,holderObject);

        client1.start();
        client2.start();
        client3.start();
    }

    private static class ThreadClient extends Thread{

        private HolderInteger holder;
        private HolderObject holderObject;

        private ThreadClient(HolderInteger holder, HolderObject holderObject){
            this.holder = holder;
            this.holderObject = holderObject;
        }

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "： value = " + holder.getHolderInt());
                System.out.println(Thread.currentThread().getName() + "： value = " + holderObject.getHolderObj().toString());
                switch (Thread.currentThread().getName()){
                    case "Thread-0":
                        holder.setHolderInt(0);
                        holderObject.setHolderData(0, "0号玩家");
                        break;
                    case "Thread-1":
                        holder.setHolderInt(1);
                        holderObject.setHolderData(1, "1号玩家");
                        break;
                    case "Thread-2":
                        holder.setHolderInt(2);
                        holderObject.setHolderData(2, "2号玩家");
                        break;
                }
                System.out.println(Thread.currentThread().getName() + "： value = " + holder.getHolderInt());
                System.out.println(Thread.currentThread().getName() + "： value = " + holderObject.getHolderObj().toString());
            }
        }
    }
}

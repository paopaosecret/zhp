package com.xander.threadtest.base;

/**
 * Created by zhaobing04 on 2019/9/19.
 * Thread.stop()方法：停止当前线程，并释放线程持有对象的锁
 */
public class StopTest {
    public static User user = new User();
    public static class User{
        private int id;
        private String name;
        public User(){
            id = 0;
            name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString(){
            return "id = " + id + ", name = " + name;
        }
    }

    public static class ChangeUserThread extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (user){
                    int v = (int)System.currentTimeMillis()/1000;
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");;
                    }
                    user.setName(String.valueOf(v));
                }
                yield();
            }
        }
    }

    public static class ReadUserThread extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (user){
                    if(user.getId() != Integer.parseInt(user.getName())){
                        System.out.println(user.toString());
                    }
                    yield();
                }
                yield();
            }
        }
    }

    public static void main(String[] args) {
        ReadUserThread read = new ReadUserThread();
        read.start();
        while(true){
            Thread change = new ChangeUserThread();
            change.start();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            change.stop();
        }
    }

    /**
     * 上述问题可以使用中断处理
     * 在ChangUserThread中判断是否被中断，如果中断则停止
     * 主线程中调用中断
     */
}

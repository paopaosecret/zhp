package com.xander.threadtest.base;

/**
 * 参考
 * https://www.cnblogs.com/barrywxx/p/10135068.html
 * https://www.jianshu.com/p/8420ade6ff76
 *
 * 在多核cpu架构下，decl指令(递减指令，相当于i--，它分为三个过程:读->改->写，
 * 这个指令涉及到两次内存操作，那么在这种情况下i的结果是无法预测的。这就是原子性问题 （解决：总线索，缓存锁）
 *
 * JMM(a++)等语句,非原子性操作 （解决：Lock，synchronized
 * Java中提供了两个高级指令 monitorenter和 monitorexit，也就是对应的synchronized同步锁来保证原子性）
 *
 * Created by zhaobing04 on 2019/9/18.
 * 原子性测试
 *
 */
public class AtomicityTest {

    private volatile int i;  //volatile 保证了可见性，有序性，但不保证原子性

    /**
     * i++由于此操作非原子性
     * 多个线程进行此操作，可能出现结果异常
     *
     * 如果要保证多线程结果正常，方法可添加synchronized关键字  对当前对象加锁，则会保证该对象此方法内方法的原子性
     */
    public void increase(){
        i++;
    }

    public int getI(){
        return i;
    }

    /**
     * {@link Thread }
     * @param threadNum  线程数量
     * @param loopTimes  循环次数
     */
    public static void test(int threadNum, int loopTimes) {
        AtomicityTest increment = new AtomicityTest();
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            Thread t = new Thread(()->{
                for(int j= 0; j< loopTimes; j++){
                    increment.increase();
                }
            });
            threads[i] = t;
            t.start();
        }

        for(Thread t: threads){
            try{
                //等待此线程结束后才执行
                t.join();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
        System.out.println(threadNum + "个线程，循环" + loopTimes + "次结果：" + increment.getI());
    }

    public static void main(String[] args) {
        test(20, 1);
        test(20, 10);
        test(20, 100);
        test(20, 1000);
        test(20, 10000);
        test(20, 100000);
    }
}

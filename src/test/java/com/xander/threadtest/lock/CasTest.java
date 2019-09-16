package com.xander.threadtest.lock;

import static com.xander.threadtest.lock.STATUS.T1;
import static com.xander.threadtest.lock.STATUS.T2;

/**
 * Created by Administrator on 2019/9/16.
 */
public class CasTest {
    static volatile STATUS T = T1;

    public static void main(String args[]){
        char[] aI = "1234567".toCharArray();
        char[] aC = "abcdefg".toCharArray();

        new Thread(()->{
            for(char c: aI){
                while (T != T1){}
                System.out.print(c);
                T = T2;
            }
        },"t1").start();

        new Thread(()->{
            for(char c: aC){
                while (T != T2){}
                System.out.print(c);
                T = T1;
            }
        },"t2").start();
    }
}

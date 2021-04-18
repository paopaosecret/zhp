package com.xander.threadtest.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhaobing04 on 2019/8/28.
 *
 * 场景：主线程需要起三个线程调用三个请求，三个请求都返回之后，主线程可以使用汇总之后的数据
 */
public class CountDownLatchTest {

    public static void main(String args[]){
        List<String> outputList = new ArrayList<>(); //1、多个请求返回数据的汇总
        List<String> inputList = new ArrayList<>();   // 请求输入参数
        inputList.add("request1");
        inputList.add("request2");


        inputList.add("request3");

        CountDownLatch latch = new CountDownLatch(inputList.size());  // 2、请求并发计数
        for (int i = 0; i < latch.getCount(); i++) {                              // 3、起三个线程，分别去调用请求请求
            Task task = new Task(inputList.subList(i,i+1), outputList, latch);
            ThreadPoolUtil.getIns().inThread(task);
        }
        System.out.println("主线程 await. ");
        try {
            latch.await();                           //4、等三个请求都结束，继续后续的操作
            System.out.println(outputList);          //5、使用三个请求汇总的数据
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程完成 await. ");
    }


}

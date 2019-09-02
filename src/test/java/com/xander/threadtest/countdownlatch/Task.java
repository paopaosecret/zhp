package com.xander.threadtest.countdownlatch;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhaobing04 on 2019/8/28.
 */
public class Task implements Runnable {

    private List<String> inputList;
    private List<String> outputList;
    private CountDownLatch latch;
    public Task(List<String> inputList,List<String> outputList, CountDownLatch latch){
        this.inputList = inputList;
        this.outputList = outputList;
        this.latch = latch;
    }


    @Override
    public void run() {
        try{
            System.out.println("请求开始:" + inputList);
            Thread.sleep(new Random().nextInt(500) + 1000);
            synchronized(this) {
                outputList.addAll(inputList);
            }
        }catch (Exception e){

        }finally {
            latch.countDown();
        }
    }
}

package com.xander.threadtest.countdownlatch;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiazhiqiang
 * Date: 2019/1/7
 * Time: 9:23
 */
public class ThreadPoolUtil {
    private static Logger logger = Logger.getLogger(ThreadPoolUtil.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    private static final ThreadPoolUtil THREAD_POOL_UTIL = new ThreadPoolUtil();

    public static ThreadPoolUtil getIns(){
        return THREAD_POOL_UTIL;
    }

    public void inThread(Runnable run){
        executorService.execute(run);
    }

    public void shutdown(){
        executorService.shutdown();
    }
}

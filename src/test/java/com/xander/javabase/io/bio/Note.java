package com.xander.javabase.io.bio;

import com.xander.utils.StringUtils;

import java.io.*;

/**
 * Created by zhaobing04 on 2020/6/18.
 *
 * BIO：阻塞IO,JDK1.4以前的唯一IO操作
 * 如测试demo，其中Server 和 Client 配合通过Socket的方式测试， 在本Demo中使用File测试
 * Server端的{@link Server#main(String[])} 方法中的server.accept()方法是阻塞的
 * Client端的{@link Client#main(String[])} 方法中对一个socket启动三个线程处理io读写，每个线程读写时都会发生阻塞
 * 本Demo中{@link Reader#run()} 中当一个线程调用readLine()方法时，其他线程如果需要调用此方法会发生阻塞，因为该方法内部实现使用了synchronized关键字
 *
 * 测试：
 * 1.先启动Server服务
 * 2.启动Client服务，Server服务则会生成一个socket与Client通信
 * 3.再启动一个Client服务，Server服务会生成一个新的socket与新的Client通信
 *
 */
public class Note {

    //简单IO测试
    public static void main(String[] args) {
        File file = new File("E:/iotest.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            new Thread(new Reader(br)).start();
            new Thread(new Reader(br)).start();
            new Thread(new Reader(br)).start();
            new Thread(new Reader(br)).start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Reader implements Runnable{
        BufferedReader br;
        public Reader(BufferedReader br){
            this.br = br;
        }

        @Override
        public void run() {
            try {
                while (true){
                    Thread.sleep(1000);
                    //当一个线程通过readLine读取时，别的线程阻塞，该方法内部使用了synchronized关键字
                    String str = br.readLine();
                    if(StringUtils.isEmpty(str)){
                        break;
                    }else{
                        System.out.println(str);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

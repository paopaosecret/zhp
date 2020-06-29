package com.xander.javabase.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zhaobing04 on 2020/6/18.
 */
public class Client {
    final static String ADDRESS = "127.0.0.1";
    final static int PORT = 12345;

    static class CliectTask implements Runnable {

        Socket socket;
        BufferedReader in;
        PrintWriter out;

        public CliectTask(Socket socket, BufferedReader in, PrintWriter out){
            this.socket = socket;
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {

            try {
                while(true){
                    out.println(Thread.currentThread() + "客户端request");
                    //向服务器端发送数据
                    String response = in.readLine();
                    System.out.println(Thread.currentThread() + ":" + response);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally{
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(ADDRESS, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            //一个socket,客户端启动三个线程处理socet交互数据，使用bio，三个线程任何一个读写，其他线程都是阻塞的
            new Thread(new CliectTask(socket, in, out)).start();
            new Thread(new CliectTask(socket, in, out)).start();
            new Thread(new CliectTask(socket, in, out)).start();
            while(true){
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

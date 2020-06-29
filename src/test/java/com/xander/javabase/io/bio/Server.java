package com.xander.javabase.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhaobing04 on 2020/6/18.
 */
public class Server {
    final static int PORT = 12345;

    public static void main(String[] args) {
        ServerSocket server = null;
        try{
            server = new ServerSocket(PORT);
            System.out.println("server start...");
            while(true){  //可以启动多个client,每个client连接时被accept（）方法返回一个socket对象
                //进行阻塞
                Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

                //新建一个线程通过socket与客户端通信
                new Thread(new ServerHandler(socket, in, out)).start();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }

    static class ServerHandler implements Runnable {

        private Socket socket;
        BufferedReader in = null;
        PrintWriter out = null;

        public ServerHandler(Socket socket, BufferedReader in, PrintWriter out){
            this.socket = socket;
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                while(true){
                    //获取客户端数据
                    String body = in.readLine();
                    System.out.println("获取到客户端数据：" +body);

                    //给客户端返回数据
                    out.println("这是服务端返回数据");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

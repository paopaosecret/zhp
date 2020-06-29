package com.xander.javabase.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by zhaobing04 on 2020/6/19.
 */
public class AsynchronousSocketChannelTest {
    static int port = 12345;
    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel asc  = AsynchronousSocketChannel.open().bind(new InetSocketAddress(port));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

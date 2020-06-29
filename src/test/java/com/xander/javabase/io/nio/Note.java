package com.xander.javabase.io.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Created by zhaobing04 on 2020/6/18.
 *
 * NIO: 同步非阻塞IO JDK1.4开始支持
 * 缓冲区（Buffer）
 * 通道（Channel）
 *
 */
public class Note {
    public static void main(String[] args) {
        testBuffer();
    }

    static void testBuffer() {
        //1、Buffer分配空间
        ByteBuffer buffer = ByteBuffer.allocate(8);
        byte a = 65;
        byte b = 66;
        //2、Buffer中放入数据
        buffer.put(a);
        buffer.put(b);
        byte c[] = new byte[0];
        try {
            c = "ppp".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        buffer.put(c);
        //3.1、Buffer中取数据
        byte get = buffer.get(3);
        System.out.println("第三个字符串是：" + get);

        //3.2、Buffer中取数据
        byte[] out = buffer.array();

        for(int i =0; i < out.length; i++){
            System.out.println("第" + i+"个：" + out[i]);
        }

        //4、重置Buffer标记属性,内存中数据还在，只是设置当前position为0
        buffer.clear();
        System.out.println(buffer.get(0));
        buffer.put((byte)90);
        System.out.println(buffer.get(0));
    }
}

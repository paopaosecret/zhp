package com.xander.javabase.io.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args){
        testFileChannel();
    }

    public static void testFileChannel(){
        File file = new File("E:/iotest.txt");
        try {
            //读写方式打开
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            int bytesRead = fileChannel.read(byteBuffer);
            while (bytesRead != -1) {
                byteBuffer.flip();//写模式转为读模式
                System.out.print(new String(byteBuffer.array()));
                byteBuffer.clear();//缓存区数据读取之后还原属性值
                bytesRead = fileChannel.read(byteBuffer);
            }
            fileChannel.close();
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

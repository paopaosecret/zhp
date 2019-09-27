package com.xander.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/9/23.
 */
public class GCTest {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while(true){
            byte[] b = new byte[1 * 1024 * 1024];
            list.add(b);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

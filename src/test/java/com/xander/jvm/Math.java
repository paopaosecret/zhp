package com.xander.jvm;


import com.xander.entity.User;

/**
 * Created by Administrator on 2019/9/21.
 * 执行过程架构图：
 * @https://www.processon.com/diagraming/5d848f22e4b00c785f30dc66
 */
public class Math {
    public static int initData = 666;
    public static User user = new User();

    public int compute(){
        int a = 2;
        int b = 3;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}

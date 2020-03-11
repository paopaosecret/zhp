package com.xander.javabase.basetype;

/**
 * Created by zhaobing04 on 2019/11/6.
 */
public class Note {

    public static void main(String[] args) {
        testByte2Int();
    }


    /**
     * 区别：计算机存储的是补码 ，byte a = -1;  //存储为1111 1111
     * 强转会导致结果的值一样，所以int b = -1; //存储为11111111 11111111 11111111 1111 1111
     * &0xff，则会将前面的位数置0，保留最后一个字节的全部bit值，也就是00000000 00000000 00000000 11111111
     */
    public static void testByte2Int(){
        byte a = -1;
        int b = a;            //b = -1;
        int c = a & 0xff;   //c = 255;

        System.out.println("a = " + a + "\nint b = a;之后 b = " + b + "\nc = a & 0xff;之后 c = " + c);

    }
}

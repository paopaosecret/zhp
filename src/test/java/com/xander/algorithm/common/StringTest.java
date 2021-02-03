package com.xander.algorithm.common;

import java.util.Scanner;

/**
 * Created by zhaobing04 on 2021/2/2.
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        getLastWord(str);
    }

    public static void getLastWord(String str){
        String[] arrays = str.trim().split(" ");
        System.out.println(arrays[arrays.length- 1].length());
    }
}

package com.xander;

import com.mysql.cj.x.protobuf.MysqlxExpr;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhaobing04 on 2020/4/26.
 * 大乐透 35 选 5 和  12 选 2 组合
 */
public class money {

    static int[] 余1 = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
    static int[] 余2 = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
    static int[] 余0 = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33};

    static int[] 排除数组 = {23,34,35};

    static int[] 余数比例 = {2,2,1};  //余0: 余1：余2 == 1:2:2；

    /**
     * @param args
     */
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        Random random = new Random(currentTime);
        int 已选的数量 = 0;

        while (已选的数量 < 5){
            int 余0的数量 = 0;
            while(余0的数量 < 余数比例[0]){
                int i = random.nextInt(10) + 1;
                if(Arrays.binarySearch(排除数组, i) < 0){
                    System.out.println(余0[i]);
                    余0的数量++ ;
                    已选的数量++;
                }
            }

            int 余1的数量 = 0;
            while(余1的数量 < 余数比例[1]){
                int i = random.nextInt(11) + 1;
                if(Arrays.binarySearch(排除数组, i) < 0){
                    System.out.println(余1[i]);
                    余1的数量++ ;
                    已选的数量++;
                }
            }

            int 余2的数量 = 0;
            while(余2的数量 < 余数比例[2]){
                int i = random.nextInt(11) + 1;
                if(Arrays.binarySearch(排除数组, i) < 0){
                    System.out.println(余2[i]);
                    余2的数量++ ;
                    已选的数量++;
                }
            }


        }

    }
}

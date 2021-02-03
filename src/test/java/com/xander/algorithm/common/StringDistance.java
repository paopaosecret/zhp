package com.xander.algorithm.common;

import com.xander.utils.StringUtil;

/**
 * Created by zhaobing04 on 2021/2/2.
 *
 * 字符串距离算法
 *
 * 问题描述：找出字符串的编辑距离，即把一个字符串s1最少经过多少步操作变成编程字符串s2，操作有三种，添加一个字符，删除一个字符，修改一个字符
 * 例如：将bcd 转换为 acdef
 *
 * 算法思想：
 *      如果一个字符串为空，则最小距离为第二个字符串的长度
 * 否则
 *      如果源字符串A和目标字符串B如果第一个字符是相同的
 *          只要计算A[2]...A[An]与B[2]...B[n]的操作次数即为距离。
 *      否则第一个字符不同，分为三种情况
 *          1.给源字符串A插入字符目标字符串B的第一个字符，然后计算A[1]...A[n]与B[2]...B[n]的距离。
 *          2.修改源字符串A的第一个值为目标字符串B的第一个值，然后计算A[2]...A[An]与B[2]...B[n]的距离。
 *          3.删除源字符串A的第一个字符，然后计算A[2]...A[An]与B[1]...B[n]的距离。
 *          总结第一个字符不同的情况：
 *          执行一步操作之后：有三种情况
 *          1.计算A[1]..A[N]与B[2]...B[n]的距离
 *          2.计算A[2]...A[N]与B[2]...B[n]的距离
 *          3.计算A[2]...A[N]B[1]...B[n]的距离
 *
 */
public class StringDistance {

    public static int distance(String str, String obj){
        if(StringUtil.isEmpty(str) || StringUtil.isEmpty(obj)){
            if(StringUtil.isEmpty(str) && StringUtil.isEmpty(obj)){
                return 0;
            }else if(StringUtil.isEmpty(str)){
                return obj.length();
            }else{
                return str.length();
            }
        }

        if(str.charAt(0) == obj.charAt(0)){
            return distance(str.substring(1), obj.substring(1));
        }

        int t1 = distance(str, obj.substring(1));
        int t2 = distance(str.substring(1), obj.substring(1));
        int t3 = distance(str.substring(1), obj);

        return 1 + Math.min(Math.min(t1,t2),t3);
    }

    public static void main(String[] args) {
        String str = "abcdef";
        String obj = "aabcde";

        System.out.println("字符串的距离：" + distance(str, obj));
    }

}

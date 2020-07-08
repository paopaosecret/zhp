package com.xander.threadtest.lambda;

/**
 * Created by zhaobing04 on 2020/7/8.
 */
public class PrimeUtil{
    public static boolean isPrime(int number) {
        if(number < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}

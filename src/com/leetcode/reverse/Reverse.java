package com.leetcode.reverse;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        int num = -123456;
        System.out.println(reverse1(num));
    }

    private static int reverse1(int num) {
        int[] rev = new int[12];
        int i = 0;
        int res = 0;
        while(num != 0){
            int a = num % 10;
            rev[i] = a;
            i++;
            num /= 10;
        }

        for(int j = 0; j < i; j++){
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && rev[j] > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && rev[j] < -8)){
                return 0;
            }
            res = res * 10 + rev[j];
        }

        return res;
    }

    private static int reverse(int num) {
        int res = 0;
        int pop = 0;
        while (num != 0){
            pop = num % 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            num /= 10;
            res = res * 10 + pop;
        }

        return  res;
    }

}

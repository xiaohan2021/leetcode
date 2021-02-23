package com.leetcode.ispalindrome;

public class IsPalinDrome {
    public static void main(String[] args) {
        int num = -12321;
        System.out.println(isPalinDrome(num));
    }

    private static boolean isPalinDrome(int num) {
        int[] rev = new int[12];
        int i = 0;
        int res = 0, pram = num;

        if(num < 0){
            return false;
        }

        while(num != 0){
            int a = num % 10;
            rev[i] = a;
            i++;
            num /= 10;
        }

        for(int j = 0; j < i; j++){
            res = res * 10 + rev[j];
        }

        return res == pram ? true : false;
    }
}

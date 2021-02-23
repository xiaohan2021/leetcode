package com.offer.missingNumber;/*
   @author: xiaohan2021
   @description: 
   @create: 2021-02-23-15:42 
*/

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10};
        int res = missingNumber(nums);
        System.out.println(res);
    }

    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        int m = 0;
        while(i <= j){
            m = (i + j) / 2;
            if (nums[m] == m){
                i = m + 1;
            } else if (nums[m] > m){
                j = m - 1;
            }
        }
        return i;
    }
}

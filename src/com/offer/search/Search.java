package com.offer.search;/*
   @author: xiaohan2021
   @description: (剑指offer53-1)排序数组中查找数字
                           统计一个数字在排序数组中出现的次数。
   @create: 2021-02-23-13:21
*/

public class Search {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int res = search(nums, target);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        /**
         * 二分查找：
         * ①target > nums[m], i = m + 1;
         * ②target < nums[m], j = m - 1;
         * ③target = nums[m], 表示找到
         * ④二分查找的结束条件：i >= j.
         *
         * 此题中，target = nums[m]需要做分类处理：
         * ①查找左边界时，如果target = nums[m]，那么j = m - 1;
         * ②查找右边界时，如果target = nums[m]，那么i = m + 1.
         */
        // 右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(target >= nums[m]) i = m + 1;
            else j = m - 1;
        }
        int right = i;

        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;

        // 左边界 left
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(target > nums[m]) i = m + 1;
            else j = m - 1;
        }
        int left = j;

        // 统计数字的个数
        int res = right - left - 1;
        return res;
    }
}

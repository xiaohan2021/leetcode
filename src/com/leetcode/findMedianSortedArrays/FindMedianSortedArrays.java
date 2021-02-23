package com.leetcode.findMedianSortedArrays;

import com.leetcode.lengthOfLongestSubstring.LengthOfLongestSubstring;

/**
 * @Description:
 * @Author: 小韩同学
 * @Date: 2020/11/17
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = null; //{1, 2, 5, 7, 8};
        int[] nums2 = {1}; //{3, 4, 6, 9};
        double num = findMedianSortedArrays(nums1, nums2);
        //double num = 5.0 / 2;
        System.out.println(num);

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = 0, len2 = 0, len = 0;
        if(nums1 != null ){
            len1 = nums1.length;
        }
        if(nums2 != null){
            len2 = nums2.length;
        }
        len = len1 + len2;
        int i = 0, j = 0;
        while(i + j < (len/2  - 1) ){
            if(nums1[i] < nums2[j]){
                if(i < nums1.length - 1){
                    i++;
                }
            } else {
                if(j < nums2.length - 1){
                    j++;
                }
            }
        }
        if(len % 2 == 1){
            return nums1[i] > nums2[j]? nums1[i] * 1.0 : nums2[j] * 1.0;
        } else {
            return  (nums1[i] * 1.0 + nums2[j])/2;
        }
    }
}

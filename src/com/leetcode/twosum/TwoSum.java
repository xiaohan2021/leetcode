package com.leetcode.twosum;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums={2,7,11,15};
        int target = 22;
        int[] res = new int[2];
        res = twoSum(nums,target);
        for(int i = 0; i < res.length; i++) {
        	System.out.print(" " + res[i] + " ");
        }
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

}

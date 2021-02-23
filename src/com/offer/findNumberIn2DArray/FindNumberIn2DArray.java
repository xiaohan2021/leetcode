package com.offer.findNumberIn2DArray;
/*
   @author xiaohan2021
   @create 2021-02-22-18:47 
*/

public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 20;
        boolean res = findNumberIn2DArray(matrix, target);
        System.out.println(res);

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length - 1, m = 0;
        while (n >= 0 && m < matrix[0].length){
            if(matrix[n][m] == target){
                return true;
            } else if (target > matrix[n][m] ) {
                m++;
            } else {
                n--;
            }
        }
        return false;
    }
}

package com.offer.spiralOrder;/*
   @author xiaohan370
   @create 2021-02-22-20:51 
*/

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
               //{1, 2, 3, 4},
                //{5, 6, 7, 8},
               // {9, 10, 11, 12}
        };
        int[] res = spiralOrder(matrix);
        int i = 0;
        while(i < res.length){
            System.out.println(res[i++]);
        }

    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length-1;
        int k = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true){
            // 从左向右
            for (int i = l; i <= r; i++) {
                res[k++] = matrix[t][i];
            }
            // t++;
            if(++t > b) break;
            // 从上至下
            for (int i = t; i <= b; i++) {
                res[k++] = matrix[i][r];
            }
            // r--;
            if(--r < l) break;
            // 从右向左
            for (int i = r; i >= l; i--) {
                res[k++] = matrix[b][i];
            }
            // b--;
            if(--b < t) break;
            // 从下向上
            for (int i = b; i >= t; i--) {
                res[k++] = matrix[i][l];
            }
            // l++;
            if(++l > r) break;
        }
        return res;
    }
}

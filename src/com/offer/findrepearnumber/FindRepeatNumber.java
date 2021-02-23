package com.offer.findrepearnumber;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(arr));
        System.out.println(Integer.toString((int) 5.4)); 
    }

    private static int findRepeatNumber(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {

            if(set.contains(arr[i])){
                return arr[i];
            } else {
                set.add(arr[i]);
            }

        }
         return -1;
    }

}

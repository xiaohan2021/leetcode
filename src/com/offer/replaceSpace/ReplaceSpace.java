package com.offer.replaceSpace;

/**
 * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Author: 小韩同学
 * @Date: 2020/11/18
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "    ";
        String res = replaceSpace(s);
        System.out.println(res);
    }

    public static String replaceSpace(String s) {
        /**
         * 我自己写的方法不可以测试字符串为全空格的情况！！！
        String res = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                res = res + arr[i] + "%20";
            } else {
                res = res + arr[i];
            }
        }
        return res;
         */
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}

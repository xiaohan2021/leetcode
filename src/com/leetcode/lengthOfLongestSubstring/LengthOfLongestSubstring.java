package com.leetcode.lengthOfLongestSubstring;

import com.sun.javafx.robot.FXRobotImage;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.sql.SQLOutput;
import java.text.BreakIterator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "bbbbbbbbb";
        System.out.println(s.charAt(0));
        int a = lengthOfLongestSubstring1(s);
        System.out.println(a);
    }

    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<Character>();
        int j = 0;
        while ( j >= 0 && j < s.length()){
            set.add(s.charAt(j));
            break;
        }
        int right = 1, max = 0;
        for (int i = 0; i < s.length(); i++) {

            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - i);
            set.remove(s.charAt(i));
        }
        return max;
}

    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}

package com.github.helloichen.leetcode.solution.subject0to9;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author iChen
 */
class Solution005 {
    /**
     * 遍历所有子串，挨个判断是否是回文。找到的第一个，就是最长的
     * 回文串的问题网上有好多算法，有个动态规划和马拉车算法好像比较厉害
     */
    public String longestPalindrome(String str) {
        if (str.length() <= 1) {
            return str;
        }
        // 子串长度
        for (int i = str.length(); i > 0; i--) {
            // 子串位置
            for (int j = 0; j <= str.length() - i; j++) {
                String sub = str.substring(j, i + j);
                // 计数，用来判断是否对称
                int count = 0;
                // 左右对称判断
                for (int k = 0; k < sub.length() / 2; k++) {
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1)) {
                        count++;
                    }
                }
                if (count == sub.length() / 2) {
                    return sub;
                }
            }
        }
        // 表示字符串中无回文子串
        return "";
    }

    public static void main(String[] args) {
        String str = "abccbaabccba1";
        Solution005 solution005 = new Solution005();
        String palindrome = solution005.longestPalindrome(str);
        System.out.println(palindrome);
    }
}

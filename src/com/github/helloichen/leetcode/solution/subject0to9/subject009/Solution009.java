package com.github.helloichen.leetcode.solution.subject0to9.subject009;

/**
 * <a href = "https://leetcode.cn/problems/palindrome-number/">9. 回文数</a>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 * @author iChen
 */
public class Solution009 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0, t = x;
        while (t != 0) {
            y = y * 10 + t % 10;
            t /= 10;
        }
        return x == y;
    }

    public static void main(String[] args) {
        int i = -121;
        Solution009 solution009 = new Solution009();
        boolean palindrome = solution009.isPalindrome(i);
        System.out.println(palindrome);
    }
}

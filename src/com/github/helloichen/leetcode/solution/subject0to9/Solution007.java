package com.github.helloichen.leetcode.solution.subject0to9;

import sun.jvm.hotspot.utilities.Assert;

/**
 * <a href="https://leetcode.cn/problems/reverse-integer/">7. 整数反转</a>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @author iChen
 */
public class Solution007 {

    public int reverse(int x) {
        long res = 0L;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }

    public static void main(String[] args) {
        int x = -100;
        Solution007 solution007 = new Solution007();
        int reverse = solution007.reverse(x);
        System.out.println(reverse);
        Assert.that(-1 == reverse, "NG");
    }
}

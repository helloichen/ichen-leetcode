package com.github.helloichen.leetcode.solution.subject020to029;

/**
 * 29 两数相除
 * https://leetcode.cn/problems/divide-two-integers/description/
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * @author iChen
 * @since 2024-03-21
 */
public class Solution029 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

    /**
     * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。
     * 本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231
     */
    public static int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        int quotient = 0;
        // 判断结果的符号
        boolean rZheng = false;
        if (divisor < 0 && dividend < 0) {
            rZheng = true;
        }
        if (divisor > 0 && dividend > 0) {
            rZheng = true;
        }
        // 全部转为负数 因为负数 -2147483648 比正数 2147483647 绝对值 大1
        if (divisor > 0) {
            divisor = -divisor;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }

        while (dividend <= divisor) {
            dividend = dividend - divisor;
            quotient++;
        }
        if (rZheng) {
            return quotient;
        } else {
            return -quotient;
        }
    }
}

package com.github.helloichen.leetcode.solution.subject10to19.subject012;

/**
 * 整数转罗马数字
 * @author iChen
 */
class Solution012 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1999));
        System.out.println(intToRoman(1));
    }

    private static String intToRoman(int num) {
        int[] nums = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}

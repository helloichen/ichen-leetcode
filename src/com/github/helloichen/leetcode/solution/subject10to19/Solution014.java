package com.github.helloichen.leetcode.solution.subject10to19;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author iChen
 */
class Solution014 {
    public static void main(String[] args) {
        String[] strs = { "flow", "flower", "flowht" };
        String commonPrefix = longestCommonPrefix1(strs);
        System.out.println(commonPrefix);
    }

    private static String longestCommonPrefix1(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        Character tempChar = null;
        for (int i = 0; ; i++) {
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (i == str.length()) {
                    return stringBuilder.toString();
                }
                char aChar = str.charAt(i);
                if (tempChar == null) {
                    tempChar = aChar;
                }
                if (aChar == tempChar) {
                    if (j == strs.length - 1) {
                        tempChar = null;
                        stringBuilder.append(aChar);
                    }
                } else {
                    return stringBuilder.toString();
                }
            }
        }
    }

    private static String longestCommonPrefix0(String[] strs) {
        int strCount = strs.length;
        Map<Integer, char[]> map = new HashMap<>(16);
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            // 判空处理
            if (strs[i] == null || "".equals(strs[i])) {
                return "";
            }
            char[] chars = strs[i].toCharArray();
            minLen = Math.min(minLen, chars.length);
            map.put(i, chars);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Character tempChar = null;
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strCount; j++) {
                char[] chars = map.get(j);
                if (tempChar == null) {
                    tempChar = chars[i];
                }
                if (tempChar == chars[i]) {
                    if (j == strCount - 1) {
                        tempChar = null;
                        stringBuilder.append(chars[i]);
                    }
                } else {
                    return stringBuilder.toString();
                }

            }
        }
        return stringBuilder.toString();
    }
}

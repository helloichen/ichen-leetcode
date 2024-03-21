package com.github.helloichen.leetcode.solution.subject020to029.subject028;

/**
 * 28 找出字符串中第一个匹配的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1
 * @author iChen
 * @since 2024-03-21
 */
public class Solution028 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (haystack.length() < needle.length()) {
            return index;
        }
        // haystack 的开始下标
        int i = 0;
        // needle 的下标
        int j = 0;

        out:
        for (; i < haystack.length(); i++) {
            // 如果 haystack 的剩余长度小于 needle 的长度直接 不用判断了
            if (j == 0 && haystack.length() - i < needle.length()) {
                break;
            }
            // 从 i 开始 往后判断
            for (int k = i; k < haystack.length(); k++) {
                if (j == needle.length()) {
                    break out;
                }
                if (haystack.charAt(k) != needle.charAt(j)) {
                    j = 0;
                    continue out;
                }
                if (j == needle.length() - 1) {
                    index = i;
                    break out;
                }
                j++;
            }
        }
        return index ;
    }
}

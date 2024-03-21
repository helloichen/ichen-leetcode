package com.github.helloichen.leetcode.solution.subject0to9;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 * @author iChen
 */
class Solution003 {
    /**
     * 定义一个哈希表记录当前窗口内出现的字符，i、j 分别表示不重复子串的开始位置和结束位置，ans 表示无重复字符子串的最大长度。
     * 遍历 s 每个字符 c，若 [i, j - 1] 窗口内存在 c，则 i 循环向右移动，更新哈希表，直至 [i, j - 1] 窗口不存在 c，循环结束。
     * 将 c 加入哈希表中，此时 [i, j] 窗口内不含重复元素，更新 ans 的最大值：ans = max(ans, j - i + 1)。
     * 最后返回 ans 即可。
     * 时间复杂度 O(n)，其中 n 表示字符串 s 的长度。
     * 双指针算法模板：
     */
    public int lengthOfLongestSubstring(String s) {
        // 窗口的起止位置
        int i = 0;
        int j = 0;
        int ans = 0;
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            while (chars.contains(c)) {
                // 前面的从set去掉
                chars.remove(s.charAt(i));
                // i++起始位置移动
                i++;
            }
            chars.add(c);
            ans = Math.max(ans, j - i + 1);
            ++j;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution003 solution003 = new Solution003();
        int length = solution003.lengthOfLongestSubstring("pwwekec");
        System.out.println(length);
    }
}

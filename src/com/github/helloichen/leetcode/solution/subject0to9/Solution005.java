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
     * 超出时间限制 时间复杂度太大
     */
    public String longestPalindrome0(String str) {
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
        String palindrome = solution005.longestPalindrome2(str);
        System.out.println(palindrome);
    }

    /**
     * 动态规划
     */
    public String longestPalindrome1(String s) {
        int length = s.length();
        //  ans[i][j]：表示从s[i...j]是否为回文串
        boolean[][] ans = new boolean[length][length];

        //  所有自己到自己都是回文串
        for (int i = 0; i < length; i++) {
            ans[i][i] = true;
        }

        int begin = 0;
        int maxLength = 1;
        for (int l = 2; l <= length; l++) {
            for (int left = 0; left < length; left++) {
                //  right - left + 1 = l
                int right = left + l - 1;

                if (right >= length) {
                    break;
                }

                //  先判断头尾字符是否相等
                if (s.charAt(left) != s.charAt(right)) {
                    ans[left][right] = false;
                } else {
                    //  如果右边界 - 左边界少于3，那么该字符串为回文字符串
                    //  因为右边界 - 左边界少于3代表着这段字符串长度为2或者3，首尾相同，剩下字符数量为0或者1，不影响
                    if (right - left < 3) {
                        ans[left][right] = true;
                    } else {
                        // 只有 s[i+1:j−1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j]才会是回文串。
                        // s[left + 1][right - 1] 的长度比 s[left][right] 短，他的值会被先计算出来
                        ans[left][right] = ans[left + 1][right - 1];
                    }
                }

                //  选择到一个回文串，然后再判断该长度是否大于最大长度，如果是，则赋值，并且记录起始和结束位置
                if (ans[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    begin = left;
                }
            }
        }
        //  分割右边界 = 起始 + 最大长度
        return s.substring(begin, begin + maxLength);
    }

    /**
     * 中心扩散
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        String res = s.charAt(0) + "";
        // 找出每个元素为中心的扩展出去的回文串，考虑奇偶长度
        for (int i = 0; i < n - 1; i++) {
            String ji = getString(s, i, i);
            String ou = getString(s, i, i + 1);
            res = res.length() > ji.length() ? res : ji;
            res = res.length() > ou.length() ? res : ou;
        }
        return res;
    }

    public String getString(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}

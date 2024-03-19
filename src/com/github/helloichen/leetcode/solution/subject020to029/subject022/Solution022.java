package com.github.helloichen.leetcode.solution.subject020to029.subject022;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * @author iChen
 * @since 2023-10-25
 */
public class Solution022 {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        function("", n, n, res);
        return res;
    }

    private static void function(String cur, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        // 剪枝 如果左括号比右括号多就不符合
        if (left > right) {
            return;
        }
        if (left > 0) {
            function(cur + "(", left - 1, right, res);
        }
        if (right > 0) {
            function(cur + ")", left, right - 1, res);
        }
    }
}

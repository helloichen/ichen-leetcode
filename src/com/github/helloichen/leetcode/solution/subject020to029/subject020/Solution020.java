package com.github.helloichen.leetcode.solution.subject020to029.subject020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @author iChen
 * @since 2023-10-18
 */
public class Solution020 {
    /**
     * 把左括号作为key 有括号作为value
     */
    static Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    /**
     * 字符串转数组，遍历数组
     * 如果是左括号直接压栈
     * 如果是右括号，用出栈的第一个左括号去map中取，如果是一样的，表示ok
     */
    public boolean isValid(String s) {
        if ("".equals(s) || s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            // 左括号，直接入栈
            if (map.containsKey(aChar)) {
                stack.push(aChar);
                continue;
            }
            // 右括号，栈为空直接false
            if (stack.isEmpty()) {
                return false;
            }
            // 右括号，与栈中第一个比较
            Character pop = stack.peek();
            if (!map.get(pop).equals(aChar)) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}

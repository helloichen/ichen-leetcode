package com.github.helloichen.leetcode.solution.subject10to19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * @author iChen
 * @since 2023-10-17
 */
public class Solution017 {

    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println(combinations);
    }

    static Map<Character, String[]> map = new HashMap<Character, String[]>() {{
        put('2', new String[] { "a", "b", "c" });
        put('3', new String[] { "d", "e", "f" });
        put('4', new String[] { "g", "h", "i" });
        put('5', new String[] { "j", "k", "l" });
        put('6', new String[] { "m", "n", "o" });
        put('7', new String[] { "p", "q", "r", "s" });
        put('8', new String[] { "t", "u", "v" });
        put('9', new String[] { "w", "x", "y", "z" });
    }};

    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> sets = new ArrayList<>();
        List<String> setOther = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            String[] strings = map.get(aChar);
            if (sets.isEmpty()) {
                for (String string : strings) {
                    setOther.add(string);
                }
            } else {
                for (String set : sets) {
                    for (String string : strings) {
                        String set1 = set.concat(string);
                        setOther.add(set1);
                    }
                }
            }
            sets = setOther;
            setOther = new ArrayList<>();
        }
        return sets;
    }
}

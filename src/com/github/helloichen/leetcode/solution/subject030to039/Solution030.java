package com.github.helloichen.leetcode.solution.subject030to039;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30 串联所有单词的子串
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * @author iChen
 * @since 2024-04-07
 */
public class Solution030 {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = { "bar", "foo", "the" };
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        // 把words搞成一个map，value存单词出现的次数
        HashMap<String, Integer> wordMap = new HashMap<>(16);
        for (String word : words) {
            Integer integer = wordMap.getOrDefault(word, 0);
            wordMap.put(word, integer + 1);
        }
        int wordsNum = words.length;
        int singleWordLength = words[0].length();
        // 遍历字符串的所有字串
        for (int i = 0; i < s.length() - wordsNum * singleWordLength + 1; i++) {
            // HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<>(16);
            // 判断过的单词数量
            int num = 0;
            while (num < wordsNum) {
                String word = s.substring(i + num * singleWordLength, i + (num + 1) * singleWordLength);
                if (wordMap.containsKey(word)) {
                    Integer value = hasWords.getOrDefault(word, 0);
                    if (value >= wordMap.get(word)) {
                        break;
                    }
                    // 出现的次数+1
                    hasWords.put(word, value + 1);
                } else {
                    break;
                }
                // 单词数量加1
                num++;
            }
            // 记录开始位置
            if (num == wordsNum) {
                result.add(i);
            }
        }
        return result;
    }

}

package com.github.helloichen.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iChen
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(print("[()]"));
        System.out.println(print("[(]]"));
    }

    static String print(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            return "NO";
        }
        int mid = length / 2;
        int right = mid;
        int left = mid - 1;

        Map<Character, Character> map = new HashMap<>(8);
        map.putIfAbsent('(', ')');
        map.putIfAbsent('[', ']');
        boolean flag = true;
        while (right < length && left > 0) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            Character character = map.get(leftChar);
            if (rightChar == character) {
                left--;
                right++;
            }else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}

package com.github.helloichen.leetcode.solution.subject0to9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 * <pre>
 *     给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * </pre>
 * @author iChen
 */
class Solution001 {

    /**
     * 用哈希表（字典）存放数组值以及对应的下标。
     * <p>
     * 遍历数组，当发现 target - nums[i] 在哈希表中，说明找到了目标值。
     * @param nums 整数数组
     * @param target 整数目标值
     * @return 下标数组
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] { map.get(num), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int target = 7;
        Solution001 solution001 = new Solution001();
        int[] ints = solution001.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}

package com.github.helloichen.leetcode.solution.subject10to19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * @author iChen
 * @since 2023-10-18
 */
public class Solution018 {

    public static void main(String[] args) {
        int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target = -294967296;
        List<List<Integer>> lists = fourSum1(nums, target);
        System.out.println(lists);
    }

    /**
     * 这个更优化 避免了无效的遍历
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = n - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        --l;
                        while (k < n && nums[k] == nums[k - 1]) {
                            ++k;
                        }
                        while (l > j && nums[l] == nums[l + 1]) {
                            --l;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        ++k;
                    } else {
                        --l;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n - 1; ++k) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    for (int l = k + 1; l < n; l++) {
                        if (l > k + 1 && nums[l] == nums[l - 1]) {
                            continue;
                        }
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }
        return res;
    }
}


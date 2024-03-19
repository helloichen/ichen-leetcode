package com.github.helloichen.leetcode.solution.subject10to19.subject015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author iChen
 */
class Solution015 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return Collections.emptyList();
        }
        // 先排序一下 对 nums 进行排序。
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2 && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针
            // 遍历数组，并以当前遍历位置作为分割线，在右侧数组当中（不包括分割元素在内），寻找两个可以组成 0 - nums[i] 的值，将该题转换为两数之和
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    // 重复的数字快速跳过 若当前遍历数值与上一个数值一致（nums[i] == nums[i - 1]），可直接跳过（去重复）。
                    while (j < n && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                    // 重复的数字快速跳过 若当前遍历数值与上一个数值一致（nums[i] == nums[i - 1]），可直接跳过（去重复）。
                    while (k > i && nums[k] == nums[k + 1]) {
                        --k;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return res;
    }
}

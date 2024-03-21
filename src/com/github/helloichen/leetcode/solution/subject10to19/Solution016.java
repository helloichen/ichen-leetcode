package com.github.helloichen.leetcode.solution.subject10to19;

/**
 * <a href ="https://leetcode.cn/problems/3sum-closest/">16 最接近的三数之和</a>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * @author iChen
 * @since 2023-10-17
 */
class Solution016 {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        Solution016 solution016 = new Solution016();
        int r = solution016.threeSumClosest0(nums, target);
        System.out.println(r);
    }

    public int threeSumClosest0(int[] nums, int target) {
        int deltaTemp = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int delta = Math.abs(target - sum);
                    if (delta == 0) {
                        return sum;
                    }
                    if (deltaTemp == 0) {
                        result = sum;
                        deltaTemp = delta;
                    }
                    if (delta < deltaTemp) {
                        result = sum;
                        deltaTemp = delta;
                    }
                }
            }
        }
        return result;
    }

}

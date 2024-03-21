package com.github.helloichen.leetcode.solution.subject10to19;

/**
 * <a href = "https://leetcode.cn/problems/container-with-most-water/">11. 盛最多水的容器</a>
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * @author iChen
 */
class Solution011 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int t = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, t);
            // 如果左边比右边低，左边右移动
            if (height[i] < height[j]) {
                i++;
            }
            // 左边比右边高，右边左移动
            else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Solution011 solution011 = new Solution011();
        int maxArea = solution011.maxArea(height);
        System.out.println(maxArea);
    }
}

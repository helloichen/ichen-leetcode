package com.github.helloichen.leetcode.solution.subject020to029.subject027;

/**
 * 27 移除元素
 * https://leetcode.cn/problems/remove-element/
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 * @author iChen
 * @since 2024-03-20
 */
public class Solution027 {
    public static void main(String[] args) {
//         int[] nums = new int[] { 0,2,4,5,6 };
        int[] nums = new int[] { 0,1,2,2,3,0,4,2 };
        int i = removeElement(nums,3);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        int i = 0;
        int last = nums.length - 1;
        while (i <= last) {
            if (nums[i] == val) {
                while (last > i && nums[last] == val) {
                    last--;
                }
                if (i == last) {
                    break;
                }
                int t = nums[last];
                nums[last] = nums[i];
                nums[i] = t;
            }
            k++;
            i++;
        }
        return k;
    }
}

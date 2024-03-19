package com.github.helloichen.demo;

import java.util.Arrays;

/**
 * 选择排序
 * @author iChen
 */
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 8, 9, 2, 3, 5, 4, 7 };
        SelectSortDemo demo = new SelectSortDemo();
        demo.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] nums) {
        // 需要选择 n-1 轮
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录每轮的最小值的位置 用于和当前位置进行交换
            int minIndex = i;
            // 记录每轮的最小值 用于和当前位置进行交换
            int min = nums[i];
            // 遍历比较，找到最小的
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            // 将最小的和当前的位置交换一下
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
    }
}

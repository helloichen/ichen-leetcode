package com.github.helloichen.demo;

import java.util.Arrays;

/**
 * 两个有序数组合并为一个有序数组
 * @author iChen
 */
public class MergeArrayDemo {
    public static void main(String[] args) {
        int[] array1 = { 1, 3, 5, 8, 12, 35, 54, 456, 2545 };
        int[] array2 = { 2, 4, 7, 10, 40, 60 };
        MergeArrayDemo demo = new MergeArrayDemo();
        int[] merge = demo.merge(array1, array2);
        System.out.println(Arrays.toString(merge));
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                nums3[i + j] = nums2[j];
                j++;
                continue;
            }
            if (j == nums2.length) {
                nums3[i + j] = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                nums3[i + j] = nums1[i];
                i++;
            } else {
                nums3[i + j] = nums2[j];
                j++;
            }
        }
        return nums3;
    }
}

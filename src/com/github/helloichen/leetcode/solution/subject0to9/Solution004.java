package com.github.helloichen.leetcode.solution.subject0to9;

/**
 * <a href = "https://leetcode.cn/problems/median-of-two-sorted-arrays/">4. 寻找两个正序数组的中位数</a>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @author iChen
 */
class Solution004 {
    /**
     * 解法
     * 本题限制了时间复杂度为 O(log (m+n))，看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。
     * 那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。
     * 这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为 m 和 n，由于两个数组长度之和 m+n 的奇偶不确定，
     * 因此需要分情况来讨论，对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。
     * 为了简化代码，不分情况讨论，我们使用一个小 trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，
     * 然后求其平均值即可，这对奇偶数均适用。假如 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，
     * 相当于两个相同的数字相加再除以 2，还是其本身。
     * 这里我们需要定义一个函数来在两个有序数组中找到第 K 个元素，下面重点来看如何实现找到第 K 个元素。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int[] nums3 = this.mergeNums(nums1, nums2);
        return (nums3[left - 1] + nums3[right - 1]) / 2.0D;
    }

    private int[] mergeNums(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int i = 0, j = 0;
        boolean num1out = false;
        boolean num2out = false;
        int[] nums3 = new int[total];
        for (int k = 0; k < total; k++) {
            if (num1out) {
                nums3[k] = nums2[j];
                j++;
                if (j >= nums2.length) {
                    num2out = true;
                }
                continue;
            }
            if (num2out) {
                nums3[k] = nums1[i];
                i++;
                if (i >= nums1.length) {
                    num1out = true;
                }
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                nums3[k] = nums1[i];
                i++;
                if (i >= nums1.length) {
                    num1out = true;
                }
            } else {
                nums3[k] = nums2[j];
                j++;
                if (j >= nums2.length) {
                    num2out = true;
                }
            }
        }
        return nums3;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3, 4, 5, 6, 7 };
        Solution004 solution004 = new Solution004();
        double medianSortedArrays = solution004.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}

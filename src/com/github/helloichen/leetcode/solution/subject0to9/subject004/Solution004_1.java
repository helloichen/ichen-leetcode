package com.github.helloichen.leetcode.solution.subject0to9.subject004;

/**
 * <a href = "https://leetcode.cn/problems/median-of-two-sorted-arrays/">4. 寻找两个正序数组的中位数</a>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @author iChen
 */
class Solution004_1 {
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
     * 首先，为了避免产生新的数组从而增加时间复杂度，我们使用两个变量 i 和 j 分别来标记数组 nums1 和 nums2 的起始位置。
     * 然后来处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，
     * 相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。
     * 还有就是如果 K=1 的话，那么我们只要比较 nums1 和 nums2 的起始位置 i 和 j 上的数字就可以了。
     * 难点就在于一般的情况怎么处理？因为我们需要在两个有序数组中找到第 K 个元素，
     * 为了加快搜索的速度，我们要使用二分法，对 K 二分，意思是我们需要分别在 nums1 和 nums2 中查找第 K/2 个元素，
     * 注意这里由于两个数组的长度不定，所以有可能某个数组没有第 K/2 个数字，所以我们需要先检查一下，
     * 数组中到底存不存在第 K/2 个数字，如果存在就取出来，否则就赋值上一个整型最大值。
     * 如果某个数组没有第 K/2 个数字，那么我们就淘汰另一个数字的前 K/2 个数字即可。
     * 有没有可能两个数组都不存在第 K/2 个数字呢，这道题里是不可能的，因为我们的 K 不是任意给的，
     * 而是给的 m+n 的中间值，所以必定至少会有一个数组是存在第 K/2 个数字的。
     * 最后是二分法的核心，比较这两个数组的第 K/2 小的数字 midVal1 和 midVal2 的大小，
     * 如果第一个数组的第 K/2 个数字小的话，那么说明我们要找的数字肯定不在 nums1 中的前 K/2 个数字，
     * 所以我们可以将其淘汰，将 nums1 的起始位置向后移动 K/2 个，并且此时的 K 也自减去 K/2，调用递归。
     * 反之，我们淘汰 nums2 中的前 K/2 个数字，并将 nums2 的起始位置向后移动 K/2 个，并且此时的 K 也自减去 K/2，调用递归即可。
     * 实际是比较两个数组中的第 K/2 个数字哪一个可能到达最后合并后排序数组中的第 K 个元素的位置，其中小的那个数字注定不可能到达，
     * 所以可以直接将小的元素对应的数组的前 K/2 个数字淘汰。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0D;
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        }
        return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}

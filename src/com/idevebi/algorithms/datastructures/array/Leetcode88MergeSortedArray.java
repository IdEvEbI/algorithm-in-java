package com.idevebi.algorithms.datastructures.array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">https://leetcode.cn/problems/merge-sorted-array/</a>
 */
public class Leetcode88MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 双指针
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后向前遍历数组
        for (int i = m + n - 1; i >= 0; i--) {
            // 取数组末尾数字
            int x1 = (m - 1 >= 0) ? nums1[m - 1] : Integer.MIN_VALUE;
            int x2 = (n - 1 >= 0) ? nums2[n - 1] : Integer.MIN_VALUE;

            // 把大的数字插入到数组的末尾
            if (x1 > x2) {
                nums1[i] = x1;
                m--;
            } else {
                nums1[i] = x2;
                n--;
            }
        }
    }

    /**
     * 利用 sort API 解题
     */
    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


}

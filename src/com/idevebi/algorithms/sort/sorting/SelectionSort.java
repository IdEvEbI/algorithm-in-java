package com.idevebi.algorithms.sort.sorting;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2, 6};

        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     * <p>
     * 排序思路：每一轮遍历，都选出最小值元素的下标，与第 i 位置的元素交换
     * 排序特点：原地 / 不稳定 / O(n^2)
     */
    private static void selectionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 1. 把 i 作为最小值元素的索引
            int minIndex = i;

            // 2. 从 i + 1 开始查找数组中的最小值，并记录索引
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // 3. 如果最小值索引与 i 不一致，交换位置
            if (minIndex != i) {
                int tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}

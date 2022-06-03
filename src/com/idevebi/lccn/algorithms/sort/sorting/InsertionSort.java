package com.idevebi.lccn.algorithms.sort.sorting;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 排序思路：从第 1 个元素开始，把每个值作为「插入的新值」，向前找到小于该新值的位置插入（需要向后搬动元素）
 * 排序特点：原地 / 稳定 / O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2, 6};

        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        // 从第 1 个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 1. 把第 i 个元素作为 新值 （抓了一张新牌）
            int newValue = nums[i];

            // 2. 向前遍历数组，如果比 新值 大，则向后搬动元素
            int j = i;
            for (; j > 0 && nums[j - 1] > newValue; j--) {
                nums[j] = nums[j - 1];
            }

            // 3. 把 新值 插入到 j 的位置
            nums[j] = newValue;
        }
    }
}

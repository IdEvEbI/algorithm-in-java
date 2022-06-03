package com.idevebi.lccn.algorithms.sort.sorting;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2, 6};

        insertionSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入排序
     * <p>
     * 排序思路：从第 1 个元素开始，把每个值作为「插入的新值」，向前找到小于该新值的位置插入（需要向后搬动元素）
     * 排序特点：原地 / 稳定 / O(n^2)
     * <p>
     * 方法 1：交换法
     */
    private static void insertionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 排序思路：从第 1 个元素开始，把每个值作为「插入的新值」，向前找到小于该新值的位置插入（需要向后搬动元素）
     * 排序特点：原地 / 稳定 / O(n^2)
     * <p>
     * 方法 2：移动法
     */
    private static void insertionSort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        // 从第 1 个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 1. 把第 i 个元素作为 新值 （抓了一张新牌）
            int newValue = nums[i];

            // 2. 向前遍历数组，新值 比 之前的值小，则向后搬动元素
            int j = i;
            for (; j > 0 && newValue < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }

            // 3. 把 新值 插入到 j 的位置
            nums[j] = newValue;
        }
    }
}

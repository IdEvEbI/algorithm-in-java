package com.idevebi.lccn.algorithms.sort.sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2, 6};

        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     * <p>
     * 排序思路：每一轮遍历，都从头开始，两两比较，把大数向后「冒」
     * 排序特点：原地 / 稳定 / O(n^2)
     */
    private static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排序标记，默认已排序完成
            boolean sorted = true;

            // 从头向后遍历数组，两两比较，将大数向后冒
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 从第 0 个元素开始两两比较，大数向后移动
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;

                    // 如果发生数据交换，说明数组排序还没有完成
                    sorted = false;
                }
            }

            // 如果一轮比较没有出现数据交换，说明已经排好序
            if (sorted) {
                break;
            }
        }
    }
}

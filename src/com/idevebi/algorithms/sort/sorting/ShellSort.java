package com.idevebi.algorithms.sort.sorting;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2, 6};

        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 希尔排序（最小增量排序）
     * <p>
     * 排序思路：把数组逐次从以增量为步长（通常从中间）拆分，每个小数组使用插入排序，例如：
     * <p>
     * 1. 先对 step 间隔的数组进行插入排序
     * 2. 再对 step / 2 的再进行一次排序
     * 3. ......
     * 4. 如果 step / 2 == 1，说明数组已经排序完成
     * <p>
     * 排序特点：原地 / 不稳定 / 平均 O(n^1.5)
     * 提示：增量元素如果不互质，则小增量可能根本不起作用，希尔排序的增量序列如何选择是一个数学界的难题。
     */
    private static void shellSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        // 以数组的一半作为 增量（步长），逐渐缩小数组
        int len = nums.length;
        for (int step = len / 2; step > 0; step /= 2) {
            // 以 step 为步长，逐个对子数组元素做插入排序
            for (int i = step; i < len; i++) {
                // 当前抓到的「牌」
                int curValue = nums[i];

                int j = i;
                for (; j >= step && curValue < nums[j - step]; j -= step) {
                    nums[j] = nums[j - step];
                }

                nums[j] = curValue;
            }
        }
    }
}

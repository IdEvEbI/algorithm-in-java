package com.idevebi.algorithms.sorting;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 排序思路：从前向后遍历数组，每次都选出最小值与第 i 位置元素交换
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     *
     * @param arr 整数数组
     */
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 把 i 作为最小值元素的索引
            int idx = i;

            // 从 i + 1 开始查找数组中的最小值，并记录索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            // 如果最小值索引与 i 不一致，交换位置
            if (idx != i) {
                int tmp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = tmp;
            }

            System.out.println("第 " + i + " 轮排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}

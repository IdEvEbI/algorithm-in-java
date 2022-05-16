package com.idevebi.algorithms.sorting;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 排序思路：从第 1 个元素开始，把每个值作为「插入的新值」，向前找到小于该新值的位置插入（需要向后搬动元素）
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr 整数数组
     */
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 从第 1 个元素开始遍历数组
        for (int i = 1; i < arr.length; i++) {
            // 把第 i 项作为插入的新值
            int newValue = arr[i];

            // 向前遍历数组，如果比 插入的新值 大，则向后搬动元素
            int j = i;
            for (; j > 0 && arr[j - 1] > newValue; j--) {
                arr[j] = arr[j - 1];
            }

            // 把 插入的新值 保存在正确的位置
            arr[j] = newValue;

            System.out.println("第 " + i + " 轮排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}

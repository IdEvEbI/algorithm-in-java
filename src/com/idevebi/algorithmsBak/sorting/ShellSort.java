package com.idevebi.algorithmsBak.sorting;

import java.util.Arrays;

/**
 * 希尔排序
 * <p>
 * 排序思路：把数组逐次从中间拆分，每个小数组使用插入排序
 * 排序特点：原地 / 不稳定 / 最好 O(n log n) / 最坏 O(n^2) / 平均 O(n^1.5)
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     *
     * @param arr 整数数组
     */
    private static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 以数组长度的一半作为 step，逐渐缩小子数组
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 从第 step 个元素开始，逐个对子数组做插入排序
            for (int i = step; i < arr.length; i++) {
                // 把第 i 项作为插入的新值
                int newValue = arr[i];

                int j = i;
                for (; j >= step && arr[j - step] > newValue; j -= step) {
                    arr[j] = arr[j - step];
                }

                // 把 插入的新值 保存在正确的位置
                arr[j] = newValue;

                System.out.println("第 " + step + "-" + i + " 轮排序");
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}

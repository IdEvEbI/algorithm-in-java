package com.idevebi.algorithms.sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 排序思路：每一轮遍历，都从头开始，两两比较，把大数向后冒
 * 排序特点：原地 / 稳定 / 最好 O(n) / 最坏 O(n^2) / 平均 O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr 整数数组
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 排序标记，默认已排序完成
            boolean sorted = true;

            // 从头向后遍历数组，两两比较，将大数向后冒
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 从第 0 个元素开始两两比较，大数向后移动
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    // 如果发生数据交换，说明数组排序还没有完成
                    sorted = false;
                }
            }

            // 如果没有数据交换，提前退出循环
            System.out.println("第 " + i + " 轮排序");
            System.out.println(Arrays.toString(arr));

            if (sorted) {
                break;
            }
        }
    }
}

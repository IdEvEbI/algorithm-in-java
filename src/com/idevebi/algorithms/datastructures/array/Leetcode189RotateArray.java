package com.idevebi.algorithms.datastructures.array;

import java.util.Arrays;

/**
 * 轮转数组
 *
 * <a href="https://leetcode.cn/problems/rotate-array/">https://leetcode.cn/problems/rotate-array/</a>
 */
public class Leetcode189RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 翻转数组
     * <p>
     * 示例：{1, 2, 3, 4, 5, 6, 7}，k = 3
     * 翻转 0~6：{7, 6, 5, 4, 3, 2, 1}
     * 翻转 0~2：{5, 6, 7, 4, 3, 2, 1}
     * 翻转 3~6：{5, 6, 7, 1, 2, 3, 4}
     */
    private static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= nums.length;

        // 全部翻转
        reverse(nums, 0, len - 1);
        // 翻转 0 ~ k -1
        reverse(nums, 0, k - 1);
        // 翻转 k ~ len - 1
        reverse(nums, k, len - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }

    /**
     * 借助辅助数组旋转
     */
    private static void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] tmpArr = new int[len];

        for (int i = 0; i < len; i++) {
            tmpArr[(i + k) % len] = nums[i];
        }
        System.arraycopy(tmpArr, 0, nums, 0, len);
    }
}

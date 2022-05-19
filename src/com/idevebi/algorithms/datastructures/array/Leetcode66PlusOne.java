package com.idevebi.algorithms.datastructures.array;

import java.util.Arrays;

/**
 * 加一
 *
 * <a href="https://leetcode.cn/problems/plus-one/">https://leetcode.cn/problems/plus-one/</a>
 */
public class Leetcode66PlusOne {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};

        nums = plusOne(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static int[] plusOne(int[] digits) {
        // 从后向前遍历数组
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;

            // 没有进位直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }

        // 循环结束仍然没有返回，说明最后还有一个进位
        // 新建数组
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}

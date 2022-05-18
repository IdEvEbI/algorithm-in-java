package com.idevebi.algorithms.datastructures.array;

import java.util.Arrays;

/**
 * 移动零
 *
 * <a href="https://leetcode.cn/problems/move-zeroes/">https://leetcode.cn/problems/move-zeroes/</a>
 */
public class Leetcode283MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     *
     * @param nums 整数数组
     */
    private static void moveZeroes(int[] nums) {
        // 记录非零元素索引
        int idx = 0;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果元素不为 0，将元素移动到 idx 位置，同时 idx++
            if (nums[i] != 0) {

                if (i != idx) {
                    nums[idx] = nums[i];
                    nums[i] = 0;
                }

                idx++;
            }
        }
    }
}

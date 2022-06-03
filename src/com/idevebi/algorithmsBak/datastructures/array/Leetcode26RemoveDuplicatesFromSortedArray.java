package com.idevebi.algorithmsBak.datastructures.array;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 *
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">https://leetcode.cn/problems/remove-duplicates-from-sorted-array/</a>
 */
public class Leetcode26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int len = removeDuplicates(nums);
        System.out.println(len + " - " + Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        // 删除完重复元素的长度
        int len = 0;

        // 从第 1 项元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {

            // 如果与前面一项元素不同
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }

        return len + 1;
    }
}

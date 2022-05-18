package com.idevebi.algorithms.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * <a href="https://leetcode.cn/problems/two-sum/">https://leetcode.cn/problems/two-sum/</a>
 */
public class Leetcode1TwoSum {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2, 7, 11, 15};

        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 从数组 nums 中找出两个整数的 和 为目标值 target，返回两个整数的下标
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 下标数组
     */
    private static int[] twoSum(int[] nums, int target) {
        // 定义哈希表，key 是整数值，value 是整数在数组中的索引
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];

            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }

            // 将 value: index 存入 map
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

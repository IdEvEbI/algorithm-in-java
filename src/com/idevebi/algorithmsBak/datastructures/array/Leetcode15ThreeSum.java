package com.idevebi.algorithmsBak.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * <a href="https://leetcode.cn/problems/3sum/">https://leetcode.cn/problems/3sum/</a>
 */
public class Leetcode15ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};

        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    /**
     * 从整数数组 nums 中，寻找三个元素 a、b、c，使得 a + b + c = 0
     *
     * @param nums 整数数组
     * @return 所有和为 0 且不重复的三元组
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // 不足 3 数直接返回
        if (nums.length < 3) {
            return ans;
        }

        // 排序数组
        Arrays.sort(nums);

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 跳过相同数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 跳过相同数字
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
}

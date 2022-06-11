package com.idevebi.datastructures.hash.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();

        int[] ans = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ans));

        ans = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 判断 nums 数组是否有足够多的数字
            if (nums == null || nums.length < 2) {
                return new int[]{};
            }

            // 定义哈希表，key 是数组中的整数值，value 是该整数在数组中的索引
            HashMap<Integer, Integer> map = new HashMap<>();

            // 遍历数组
            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];

                if (map.containsKey(key)) {
                    // 结果已经找到，返回 key 和 i 组成的数组
                    return new int[]{map.get(key), i};
                }

                map.put(nums[i], i);
            }

            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        Solution solution = new ArrayPartitionI().new Solution();

        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(solution.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * <p>
         * 1. 对数组进行排序
         * 2. 尽量使用"大"的数字组合成对，保证总和最大，最大的和倒数第二大的结对，……依次类推
         * <p>
         * 最终解法：① 排序数组；② 奇数位数字相加
         */
        public int arrayPairSum(int[] nums) {
            // 1. 给数组排序
            Arrays.sort(nums);

            // 2. 奇数位数字相加
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.array.leetcode.editor.cn;

/**
 * 724. 寻找数组的中心下标
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        Solution solution = new FindPivotIndex().new Solution();

        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(solution.pivotIndex(new int[]{2, 1, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            return preSum(nums);
        }

        /**
         * 方法 2：前缀和
         * <p>
         * total = 2 * 前半段和 + nums[i]
         */
        private int preSum(int[] nums) {
            // 前半段和
            int preSum = 0;

            // 数组总和
            int total = 0;
            for (int n : nums) {
                total += n;
            }

            for (int i = 0; i < nums.length; i++) {
                if (2 * preSum == total - nums[i]) {
                    return i;
                }
                preSum += nums[i];
            }

            return -1;
        }

        /**
         * 方法 1：穷举法
         */
        private int bruteForce(int[] nums) {
            int len = nums.length;

            // 从左至右依次确定中心点
            for (int m = 0; m < len; m++) {
                int lSum = 0;
                int rSum = 0;

                // 中心点左侧累加
                for (int l = 0; l < m; l++) {
                    lSum += nums[l];
                }
                // 中心点右侧累加
                for (int r = m + 1; r < len; r++) {
                    rSum += nums[r];
                }

                if (lSum == rSum) {
                    return m;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
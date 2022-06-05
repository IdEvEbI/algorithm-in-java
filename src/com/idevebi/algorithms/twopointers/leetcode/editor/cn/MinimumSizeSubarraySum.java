package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

/**
 * 209. 长度最小的子数组
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();

        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            return slidingWindow(target, nums);
        }

        /**
         * 方法 2：滑动窗口
         */
        private int slidingWindow(int target, int[] nums) {
            int len = nums.length;
            int ans = Integer.MAX_VALUE;
            int sum = 0;

            for (int left = 0, right = 0; right < len; right++) {
                sum += nums[right];

                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left++];
                }
            }

            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

        /**
         * 方法 1：暴力解法（双重 for 循环）
         */
        private int bruteForce(int target, int[] nums) {
            int len = nums.length;
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < len; i++) {
                int sum = 0;

                // 从 i 开始扫描数组
                for (int j = i; j < len; j++) {
                    sum += nums[j];

                    // 找到目标数组，更新最小数组长度
                    if (sum >= target) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }

            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
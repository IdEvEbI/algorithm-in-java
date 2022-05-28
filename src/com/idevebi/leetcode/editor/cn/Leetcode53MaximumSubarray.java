package com.idevebi.leetcode.editor.cn;

/**
 * 题解参考链接：<a href="https://leetcode.cn/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/">https://leetcode.cn/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/</a>
 */
public class Leetcode53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Leetcode53MaximumSubarray().new Solution();

        System.out.println(solution.maxSubArray(new int[]{-2, 1}));
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                // 如果前一个数 > 0，将前面的数字加到当前数字
                if (nums[i - 1] > 0) {
                    nums[i] += nums[i - 1];
                }
                max = Math.max(max, nums[i]);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
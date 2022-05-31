package com.idevebi.leetcode.editor.cn;

public class Leetcode42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Leetcode42TrappingRainWater().new Solution();

        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         */
        public int trap(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }

            // 从左向右扫描的最大值数组
            int[] leftMax = new int[n];
            // 从右向左扫描的最大值数组
            int[] rightMax = new int [n];

            // 1. 从左向右扫描，生成向右的最大值数组
            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            // 2. 从右向左扫描，生成向左的最大值数组
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            // 3. 扫描两个数组，计算面积
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
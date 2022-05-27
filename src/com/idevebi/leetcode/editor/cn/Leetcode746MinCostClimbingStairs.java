package com.idevebi.leetcode.editor.cn;

public class Leetcode746MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Leetcode746MinCostClimbingStairs().new Solution();

        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;

            int prev = 0;
            int curr = 0;

            for (int i = 2; i <= n; i++) {
                int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);

                prev = curr;
                curr = next;
            }

            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
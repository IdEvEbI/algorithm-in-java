package com.idevebi.leetcode.editor.cn;

public class Leetcode45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new Leetcode45JumpGameIi().new Solution();

        System.out.println(solution.jump(new int[]{2, 3, 1, 2, 4, 2, 3}));
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心算法
         */
        public int jump(int[] nums) {
            // 能够到达的最远距离
            int maxPosition = 0;
            // 需要跳跃的步数
            int steps = 0;
            int end = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);

                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }

            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
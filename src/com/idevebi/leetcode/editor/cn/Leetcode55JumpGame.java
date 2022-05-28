package com.idevebi.leetcode.editor.cn;

public class Leetcode55JumpGame {
    public static void main(String[] args) {
        Solution solution = new Leetcode55JumpGame().new Solution();

        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心算法
         */
        public boolean canJump(int[] nums) {
            // 能够到达的最远位置
            int reach = 0;

            // 遍历数组，依次找到每个元素最远能够到达的位置
            for (int i = 0; i < nums.length; i++) {
                if (i <= reach) {
                    // 当前索引所能跳到的最远距离
                    reach = Math.max(i + nums[i], reach);
                    // 如果已经能够到达尾部，直接返回
                    if (reach >= nums.length - 1) {
                        return true;
                    }
                } else {
                    return false;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
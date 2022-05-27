package com.idevebi.leetcode.editor.cn;

public class Leetcode213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new Leetcode213HouseRobberIi().new Solution();

        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;

            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return nums[0];
            }
            if (len == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(rob(nums, 0, len - 2),
                    rob(nums, 1, len - 1));
        }

        private int rob(int[] nums, int start, int end) {
            int first = nums[start];
            int second = Math.max(nums[start], nums[start + 1]);

            for (int i = start + 2; i <= end; i++) {
                int tmp = second;
                second = Math.max(second, first + nums[i]);
                first = tmp;
            }

            return second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
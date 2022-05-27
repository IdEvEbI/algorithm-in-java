package com.idevebi.leetcode.editor.cn;

public class Leetcode198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new Leetcode198HouseRobber().new Solution();

        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
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
            // 偷第 1 个房间获得的钱
            int first = nums[0];
            // 偷前 2 个房间获得的钱
            int second = Math.max(nums[0], nums[1]);

            for (int i = 2; i < len; i++) {
                int tmp = second;
                second = Math.max(second, first + nums[i]);
                first = tmp;
            }

            return second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
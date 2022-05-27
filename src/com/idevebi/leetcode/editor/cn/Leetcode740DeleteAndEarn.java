package com.idevebi.leetcode.editor.cn;

public class Leetcode740DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new Leetcode740DeleteAndEarn().new Solution();

        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {

            // 找出数组中的最大值
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }

            // 计数数组
            int[] sum = new int[max + 1];
            for (int num : nums) {
                sum[num] += num;
            }

            return rob(sum);
        }

        private int rob(int[] nums) {
            int len = nums.length;
            int first = nums[0];
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
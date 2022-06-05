package com.idevebi.datastructures.array.leetcode.editor.cn;

/**
 * 485. 最大连续 1 的个数
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();

        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int count = 0;

            // 遍历数组
            for (int n : nums) {
                // 遇到 0，重置计数
                if (n == 0) {
                    max = Math.max(max, count);
                    count = 0;
                } else {
                    count++;
                }
            }

            return Math.max(max, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
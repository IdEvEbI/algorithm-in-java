package com.idevebi.algorithms.bitmanipulation.leetcode.editor.cn;

/**
 * 136. 只出现一次的数字
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();

        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. 任何数字 与 0 异或 等于其本身
         * 2. 任何数字异或自己 等于 0
         * <p>
         * a ⊕ b ⊕ a = b ⊕ a ⊕ a = b ⊕ (a ⊕ a) = b ⊕ 0 = b
         */
        public int singleNumber(int[] nums) {
            int single = 0;

            for (int num : nums) {
                single ^= num;
            }

            return single;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
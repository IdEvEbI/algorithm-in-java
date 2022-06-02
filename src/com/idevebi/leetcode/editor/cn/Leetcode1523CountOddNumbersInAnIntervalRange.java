package com.idevebi.leetcode.editor.cn;

public class Leetcode1523CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {
        Solution solution = new Leetcode1523CountOddNumbersInAnIntervalRange().new Solution();

        System.out.println(solution.countOdds(3, 7));
        System.out.println(solution.countOdds(9, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. 0 ~ high 之间的奇数个数 = (high + 1) / 2，例如：（10:5 / 9:5）
         * 2. 0 ~ low 之间奇数的个数 = low / 2
         * 3. 二者相减
         */
        public int countOdds(int low, int high) {
            return (high + 1) / 2 - (low) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
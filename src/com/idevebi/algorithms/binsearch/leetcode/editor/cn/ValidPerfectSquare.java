package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

/**
 * 367. 有效的完全平方数
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();

        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(14));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 0;
            int right = num;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long s = (long) mid * mid;

                if (s < num) {
                    left = mid + 1;
                } else if (s > num) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
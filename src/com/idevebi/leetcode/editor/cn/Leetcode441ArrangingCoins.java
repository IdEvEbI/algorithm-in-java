package com.idevebi.leetcode.editor.cn;

public class Leetcode441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new Leetcode441ArrangingCoins().new Solution();

        System.out.println(solution.arrangeCoins(1));
        System.out.println(solution.arrangeCoins(2));
        System.out.println(solution.arrangeCoins(3));
        System.out.println(solution.arrangeCoins(4));
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(6));
        System.out.println(solution.arrangeCoins(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：二分法 n = x * (x + 1) / 2
         */
        public int arrangeCoins(int n) {
            int left = 1;
            int right = n;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;

                if ((long) mid * (mid + 1) <= (long) 2 * n) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        /**
         * 方法 2：数学
         */
        public int arrangeCoins2(int n) {
            // n = x * (x + 1) / 2
            // 2n = x * x + x
            // x = (开平方 (8 * n + 1) - 1) / 2
            return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

/**
 * 633. 平方数之和
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();

        System.out.println(solution.judgeSquareSum(1000));
        System.out.println(solution.judgeSquareSum(3));
        System.out.println(solution.judgeSquareSum(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {

            return judgeWithTwoPoint(c);
        }

        /**
         * 方法 2：使用双指针
         */
        private boolean judgeWithTwoPoint(int c) {
            int left = 0;
            int right = (int) Math.sqrt(c);

            while (left <= right) {
                long sum = (long) left * left + right * right;

                if (sum == c) {
                    // System.out.println(left + "-" + right);
                    return true;
                } else if (sum > c) {
                    right--;
                } else {
                    left++;
                }
            }

            return false;
        }

        /**
         * 方法 1：使用 sqrt
         */
        private boolean judgeWithSqrt(int c) {
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a * a);
                if (b - (int) b == 0) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
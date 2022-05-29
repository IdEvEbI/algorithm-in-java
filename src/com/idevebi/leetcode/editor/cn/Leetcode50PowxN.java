package com.idevebi.leetcode.editor.cn;

public class Leetcode50PowxN {
    public static void main(String[] args) {
        Solution solution = new Leetcode50PowxN().new Solution();

        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(2, -2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 方法 1 & 2： 递归 & 迭代
         */
        public double myPow(double x, int n) {
            // Tip：8 位的符号数中，-128 取绝对值会越界
            long N = n;
            return N >= 0 ? diviedPow(x, N) : 1.0 / diviedPow(x, -N);
        }

        /**
         * 迭代
         */
        private double diviedPow(double x, long n) {
            double ans = 1.0;

            while (n > 0) {
                // 如果是奇数，多乘 1 次
                if (n % 2 == 1) {
                    ans *= x;
                }
                x *= x;

                n /= 2;
            }

            return ans;
        }

        /**
         * 递归
         */
        private double diviedPow2(double x, long n) {
            if (n == 0) {
                return 1;
            }
            double y = diviedPow(x, n / 2);

            // 根据奇偶数返回不同的结果
            return n % 2 == 0 ? y * y : y * y * x;
        }

        /**
         * 方法 3：暴力求解（无法通过 leetcode 测试）
         * 时间复杂度 O（n）
         * 失败案例：x = 1.00000, n = 2147483647
         */
        public double myPow2(double x, int n) {
            double res = 1;

            for (int i = 0; i < Math.abs(n); i++) {
                res *= x;
            }

            if (n < 0) {
                res = 1.0 / res;
            }

            return res;
        }

        /**
         * 方法 4：调用 pow API
         */
        public double myPow3(double x, int n) {
            return Math.pow(x, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
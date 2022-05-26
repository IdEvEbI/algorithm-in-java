package com.idevebi.leetcode.editor.cn;

/**
 * 1137. 第 N 个泰波那契数
 * <p>
 * 题目链接：<a href="https://leetcode.cn/problems/n-th-tribonacci-number/">https://leetcode.cn/problems/n-th-tribonacci-number/</a>
 */
public class Leetcode1137NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Leetcode1137NThTribonacciNumber().new Solution();

        System.out.println(solution.tribonacci(4));
        System.out.println(solution.tribonacci(25));
        System.out.println(solution.tribonacci(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n <= 2) {
                return 1;
            }

            // F(n) = F(n-1) + F(n-2) + F(n-3)
            int ans = 2;
            // F(n-1) 和 F(n-2) 和 F(n-3)
            int last = 1, preLast = 1, prePreLast = 0;

            for (int i = 3; i <= n; i++) {
                ans = last + preLast + prePreLast;

                prePreLast = preLast;
                preLast = last;
                last = ans;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
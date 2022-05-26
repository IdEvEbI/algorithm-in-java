package com.idevebi.leetcode.editor.cn;

/**
 * 509. 斐波那契数
 * <p>
 * 题目链接：<a href=" https://leetcode.cn/problems/fibonacci-number"> https://leetcode.cn/problems/fibonacci-number</a>/
 */
public class Leetcode509FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Leetcode509FibonacciNumber().new Solution();

        System.out.println(solution.fib(5));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n < 2) {
                return n;
            }

            // F(n) = F(n-1) + F(n-2)
            int ans = 1;
            // F(n-1) 和 F(n-2)
            int last = 1, preLast = 1;

            for (int i = 2; i < n; i++) {
                ans = last + preLast;

                preLast = last;
                last = ans;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
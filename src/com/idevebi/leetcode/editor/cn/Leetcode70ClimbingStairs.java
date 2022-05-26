package com.idevebi.leetcode.editor.cn;

public class Leetcode70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Leetcode70ClimbingStairs().new Solution();

        System.out.println(solution.climbStairs(0));
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0 阶台阶：1 种（不用迈步）
         * 1 阶台阶：1 种（1）
         * 2 阶台阶：2 种（1 + 1 / 2）
         * 3 阶台阶：先踏上 1 阶 + 剩余 2 阶
         * ……
         * 推导公式： f(x) = f(x - 1) + f(x - 2)
         * <p>
         * 公式与斐波那契数列一致
         */
        public int climbStairs(int n) {
            if (n < 2) {
                return n;
            }

            int ans = 1;
            int last = 1, preLast = 1;

            for (int i = 2; i <= n; i++) {
                ans = last + preLast;

                preLast = last;
                last = ans;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.algorithms.bitmanipulation.leetcode.editor.cn;

/**
 * 231. 2 的幂
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();

        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(64));
        System.out.println(solution.isPowerOfTwo(63));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int BIG = 1 << 30;

        public boolean isPowerOfTwo(int n) {
            // return n > 0 && BIG % n == 0;
            // return n > 0 && (n & -n) == n;

            return n > 0 && (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
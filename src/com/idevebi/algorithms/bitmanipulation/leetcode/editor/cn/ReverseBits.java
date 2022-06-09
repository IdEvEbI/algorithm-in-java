package com.idevebi.algorithms.bitmanipulation.leetcode.editor.cn;

/**
 * 190. 颠倒二进制位
 */
public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();

        System.out.println(solution.reverseBits(1));
        System.out.println(solution.reverseBits(43261596));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int rev = 0;

            for (int i = 0; i < 32 && n != 0; ++i) {
                rev |= (n & 1) << (31 - i);

                n >>>= 1;
            }

            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.lccn.skills.leetcode.editor.cn;

/**
 * 191. 位1的个数
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new NumberOf1Bits().new Solution();

        System.out.println(solution.hammingWeight(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value

        /**
         * 方法 1：位运算 n & (n - 1) 循环的次数就是 n 中 1 的个数
         * <p>
         * 举例：
         * 6 & 5 = 110 & 101 = 100 → 4 & 3 = 100 & 011 = 0
         * 8 & 7 = 1000 & 0111 = 0
         * 7 & 6 = 111 & 110 = 110 → 6 …
         */
        public int hammingWeight(int n) {
            int ans = 0;
            for (; n != 0; ans++) {
                n = n & (n - 1);
            }
            return ans;
        }

        /**
         * 方法 2：使用 bitCount API
         */
        public int hammingWeight2(int n) {
            return Integer.bitCount(n);
        }

        /**
         * 方法 3：n 与 2 ^ i 进行与运算
         */
        public int hammingWeight3(int n) {
            int ans = 0;

            // 1 个 int 需要 4 个 Byte，一共 32 位
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i;

                if ((n & mask) != 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
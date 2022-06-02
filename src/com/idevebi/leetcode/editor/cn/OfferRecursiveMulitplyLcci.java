package com.idevebi.leetcode.editor.cn;

/**
 * 面试题 08.05. 递归乘法
 * <p>
 * <a href="https://leetcode.cn/problems/recursive-mulitply-lcci/">https://leetcode.cn/problems/recursive-mulitply-lcci/</a>
 */
public class OfferRecursiveMulitplyLcci {
    public static void main(String[] args) {
        Solution solution = new OfferRecursiveMulitplyLcci().new Solution();

        System.out.println(solution.multiply(1024, 2));
        System.out.println(solution.multiply(3, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int multiply(int A, int B) {
            // 特殊数字处理
            if (A == 0 || B == 0) {
                return 0;
            }
            if (B == 1) {
                return A;
            }
            if (A == 1) {
                return B;
            }
            // 交换两数，保证 A <= B
            if (A > B) {
                int tmp = B;
                B = A;
                A = tmp;
            }
            return multiply(A - 1, B) + B;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
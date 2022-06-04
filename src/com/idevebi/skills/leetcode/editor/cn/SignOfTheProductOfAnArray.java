package com.idevebi.skills.leetcode.editor.cn;

/**
 * 1822. 数组元素积的符号
 */
public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        Solution solution = new SignOfTheProductOfAnArray().new Solution();

        System.out.println(solution.arraySign(new int[]{-1, 1, -1, 1, -1}));
        System.out.println(solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(solution.arraySign(new int[]{1, 5, 0, 2, -3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arraySign(int[] nums) {
            boolean sign = true;

            for (int n : nums) {
                if (n == 0) {
                    return 0;
                } else if (n < 0) {
                    sign = !sign;
                }
            }

            return sign ? 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
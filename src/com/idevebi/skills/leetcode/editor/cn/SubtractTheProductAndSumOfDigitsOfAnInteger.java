package com.idevebi.skills.leetcode.editor.cn;

/**
 * 1281. 整数的各位积和之差
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();

        System.out.println(solution.subtractProductAndSum(234));
        System.out.println(solution.subtractProductAndSum(4421));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subtractProductAndSum(int n) {
            int m = 1;
            int s = 0;

            while (n != 0) {
                int num = n % 10;

                m *= num;
                s += num;

                n /= 10;
            }

            return m - s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
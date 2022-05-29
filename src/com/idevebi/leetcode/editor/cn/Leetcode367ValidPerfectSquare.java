package com.idevebi.leetcode.editor.cn;

public class Leetcode367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new Leetcode367ValidPerfectSquare().new Solution();

        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(14));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 0;
            int right = num;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long s = (long) mid * mid;

                if (s < num) {
                    left = mid + 1;
                } else if (s > num) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
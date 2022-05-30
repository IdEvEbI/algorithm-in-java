package com.idevebi.leetcode.editor.cn;

public class Leetcode69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Leetcode69Sqrtx().new Solution();

        System.out.println(solution.mySqrt(2));
        System.out.println(solution.mySqrt(3));
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(24));
        System.out.println(solution.mySqrt(36));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // 0 和 1 直接返回
            if (x < 2) {
                return x;
            }

            int left = 0;
            int right = x / 2;
            int ans = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if ((long) mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
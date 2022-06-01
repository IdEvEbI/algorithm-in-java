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
        /**
         * 方法 1：牛顿迭代法
         */
        public int mySqrt(int x) {
            return (int) ntSqrt(x);
        }

        private double ntSqrt(int x) {
            if (x < 0) {
                return -1;
            }
            double sq = x;

            // 调整精度越精细，计算结果越准确，例如 1e-8
            double precision = 0.5;
            while (Math.abs(x - sq * sq) >= precision) {
                sq = (x / sq + sq) / 2.0;
            }

            return sq;
        }

        /**
         * 方法 2：二分法
         */
        public int mySqrt2(int x) {
            // 0 和 1 直接返回
            if (x < 2) {
                return x;
            }

            int left = 0;
            int right = x;
            int ans = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid == x / mid) {
                    return mid;
                } else if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    ans = mid;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
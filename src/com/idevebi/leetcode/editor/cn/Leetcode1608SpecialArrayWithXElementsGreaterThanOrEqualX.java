package com.idevebi.leetcode.editor.cn;

public class Leetcode1608SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        Solution solution = new Leetcode1608SpecialArrayWithXElementsGreaterThanOrEqualX().new Solution();

        System.out.println(solution.specialArray(new int[]{3, 5}));
        System.out.println(solution.specialArray(new int[]{0, 0}));
        System.out.println(solution.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(solution.specialArray(new int[]{3, 6, 7, 7, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. 目标：在 [1, nums.length] 之间查找特征值 x
         * 1. 特征值不可能为 0
         * 2. x 有可能不是 nums 中的数字
         * 2. 定义目标数，用 二分查找 的方式实现
         */
        public int specialArray(int[] nums) {
            int left = 1;
            int right = nums.length;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 在 nums 中查找大于或等于 mid 的数量
                int count = search(nums, mid);

                if (count == mid) {
                    return mid;
                } else if (count < mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return -1;
        }

        /**
         * 在 nums 数组中搜索大于等于 target 的数量
         */
        private int search(int[] nums, int target) {
            int count = 0;

            for (int n : nums) {
                count += (n >= target) ? 1 : 0;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();

        int[] res = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(res));

        res = solution.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            return sortedWithTwoPointers(nums);
        }

        /**
         * 方法 2：双指针
         */
        private int[] sortedWithTwoPointers(int[] nums) {
            int len = nums.length;
            // 结果数组
            int[] ans = new int[len];

            // 当前需要更新数组的位置（从后向前保存）
            int pos = len - 1;

            // left 从数组头部向右移动
            // right 从数组尾部向左移动
            for (int left = 0, right = len - 1; left <= right; ) {
                // 1. 计算两个平方和
                int p1 = nums[left] * nums[left];
                int p2 = nums[right] * nums[right];

                // 2. 如果 p1 > p2，移动左指针 i
                if (p1 > p2) {
                    ans[pos] = p1;
                    left++;
                } else {
                    // 否则移动右指针 j
                    ans[pos] = p2;
                    right--;
                }

                // 3. 更新位置指针
                pos--;
            }

            return ans;
        }

        /**
         * 方法 1：调用数组 sort API
         */
        private int[] sortedWithAPI(int[] nums) {
            // 1. 计算平方和
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            // 2. 排序数组
            Arrays.sort(nums);

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
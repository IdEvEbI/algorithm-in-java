package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode977SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new Leetcode977SquaresOfASortedArray().new Solution();

        int[] res = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(res));

        res = solution.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：双指针
         */
        public int[] sortedSquares(int[] nums) {
            int len = nums.length;
            // 结果数组
            int[] ans = new int[len];

            // 当前需要更新数组的位置（从后向前保存）
            int pos = len - 1;

            // 变量 i 从数组头部向右移动
            // 变量 j 从数组尾部向左移动
            for (int i = 0, j = len - 1; i <= j; ) {
                // 1. 计算两个平方和
                int p1 = nums[i] * nums[i];
                int p2 = nums[j] * nums[j];

                // 2. 如果 p1 > p2，移动左指针 i
                if (p1 > p2) {
                    ans[pos] = p1;
                    i++;
                } else {
                    // 否则移动右指针 j
                    ans[pos] = p2;
                    j--;
                }

                // 3. 更新位置指针
                pos--;
            }

            return ans;
        }

        /**
         * 方法 2：调用数组 sort API
         */
        public int[] sortedSquares2(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
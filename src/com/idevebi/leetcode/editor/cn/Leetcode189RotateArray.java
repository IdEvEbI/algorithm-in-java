package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode189RotateArray {
    public static void main(String[] args) {
        Solution solution = new Leetcode189RotateArray().new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 翻转数组
         * <p>
         * 示例：{1, 2, 3, 4, 5, 6, 7}，k = 3
         * 翻转 0~6：{7, 6, 5, 4, 3, 2, 1}
         * 翻转 0~2：{5, 6, 7, 4, 3, 2, 1}
         * 翻转 3~6：{5, 6, 7, 1, 2, 3, 4}
         */
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k %= len;

            // 1. 全部翻转
            rotate(nums, 0, len - 1);
            // 2. 翻转前半部分
            rotate(nums, 0, k - 1);
            // 3. 翻转后半部分
            rotate(nums, k, len - 1);
        }

        /**
         * 反转指定索引范围的数组内容
         *
         * @param nums  数组
         * @param start 起始索引
         * @param end   结束索引
         */
        private void rotate(int[] nums, int start, int end) {
            for (; start < end; start++, end--) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
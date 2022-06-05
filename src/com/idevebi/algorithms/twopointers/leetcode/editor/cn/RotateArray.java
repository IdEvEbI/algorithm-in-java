package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 189. 轮转数组
 */
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            rotateWithReverse(nums, k);
        }

        /**
         * 方法 3：翻转数组
         * <p>
         * 示例：{1, 2, 3, 4, 5, 6, 7}，k = 3
         * 翻转 0~6：{7, 6, 5, 4, 3, 2, 1}
         * 翻转 0~2：{5, 6, 7, 4, 3, 2, 1}
         * 翻转 3~6：{5, 6, 7, 1, 2, 3, 4}
         */
        private void rotateWithReverse(int[] nums, int k) {
            int len = nums.length;
            k %= len;

            // 1. 全部翻转
            rotateWithReverse(nums, 0, len - 1);
            // 2. 翻转前半部分
            rotateWithReverse(nums, 0, k - 1);
            // 3. 翻转后半部分
            rotateWithReverse(nums, k, len - 1);
        }

        private void rotateWithReverse(int[] nums, int start, int end) {
            for (; start < end; start++, end--) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }

        /**
         * 方法 2：双指针
         */
        private void rotateWithTwoPoint(int[] nums, int len, int k) {
            // 如果移动的是整圈，直接返回
            k = k % len;
            if (k == 0) {
                return;
            }

            int pre = 0;
            int rear = k;

            while (rear != len) {
                pre = 0;

                while (pre < k && rear != len) {
                    int temp = nums[pre];
                    nums[pre++] = nums[rear];
                    nums[rear++] = temp;
                }
            }

            rotateWithTwoPoint(nums, k, k - pre);
        }

        /**
         * 方法 1：使用中转数组
         */
        private void rotateWithOtherArray(int[] nums, int k) {
            int len = nums.length;
            int[] arr = new int[len];

            for (int i = 0; i < len; i++) {
                arr[(i + k) % len] = nums[i];
            }

            System.arraycopy(arr, 0, nums, 0, len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
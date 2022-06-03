package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class OfferSortAnArray {
    public static void main(String[] args) {
        Solution solution = new OfferSortAnArray().new Solution();

        int[] nums = {99, 5, 4, 3, 2, 1};

        nums = solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);

            return nums;
        }

        /**
         * 归并排序（归：拆分数组）
         */
        private void mergeSort(int[] nums, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;

                mergeSort(nums, left, mid);
                mergeSort(nums, mid + 1, right);

                merge(nums, left, mid, right);
            }
        }

        /**
         * 归并排序（并：合并数组）
         */
        private void merge(int[] nums, int left, int mid, int right) {
            // 1. 定义一个临时数组
            int[] temparr = new int[right - left + 1];

            // 2. 遍历 left → right 之间的数字存储临时数组
            int l = left, r = mid + 1, i = 0;
            while (l <= mid && r <= right) {
                if (nums[l] <= nums[r]) {
                    temparr[i++] = nums[l++];
                } else {
                    temparr[i++] = nums[r++];
                }
            }

            // 3. 处理剩余数据
            if (l <= mid) {
                System.arraycopy(nums, l, temparr, i, mid - l + 1);
            }
            if (r <= right) {
                System.arraycopy(nums, r, temparr, i, right - r + 1);
            }

            // 4. 覆盖原数组
            System.arraycopy(temparr, 0, nums, left, right - left + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
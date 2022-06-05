package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();

        int[] nums = {1, 2, 3, 0, 0, 0};
        solution.merge(nums, 3, new int[]{2, 5, 6}, 3);

        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 从后向前遍历数组
            for (int i = m + n - 1; i >= 0; i--) {
                // 取数组末尾数字
                int x1 = (m - 1 >= 0) ? nums1[m - 1] : Integer.MIN_VALUE;
                int x2 = (n - 1 >= 0) ? nums2[n - 1] : Integer.MIN_VALUE;

                // 把大的数字插入到数组的末尾
                if (x1 > x2) {
                    nums1[i] = x1;
                    m--;
                } else {
                    nums1[i] = x2;
                    n--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
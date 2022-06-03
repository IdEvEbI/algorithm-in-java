package com.idevebi.algorithms.sort.leetcode.editor.cn;

/**
 * 215. 数组中的第K个最大元素
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();

        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 提示：题目要求找到第 k 个最大的元素，因此不需要对数组完全排序
         * <p>
         * 可以使用选择排序，降序排列数组，但只排序前 k 个元素
         */
        public int findKthLargest(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                // 1. 把 i 作为最大值元素的索引
                int maxIndex = i;

                // 2. 从 i + 1 开始查找数组中的最大值，并记录索引
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[maxIndex] < nums[j]) {
                        maxIndex = j;
                    }
                }

                // 3. 如果最大值索引与 i 不一致，交换位置
                if (maxIndex != i) {
                    int tmp = nums[maxIndex];
                    nums[maxIndex] = nums[i];
                    nums[i] = tmp;
                }
            }

            return nums[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
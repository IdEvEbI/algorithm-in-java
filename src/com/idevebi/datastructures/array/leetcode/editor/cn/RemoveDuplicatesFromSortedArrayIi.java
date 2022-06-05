package com.idevebi.datastructures.array.leetcode.editor.cn;

/**
 * 80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();

        System.out.println(solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解题思路：数组是有序的，最多出现两次
         * <p>
         * 可以使用双指针，slow 记录删除后的数组长度，fast 负责向前扫描
         */
        public int removeDuplicates(int[] nums) {
            int len = nums.length;

            if (len <= 2) {
                return len;
            }

            int slow = 2;
            for (int fast = 2; fast < len; fast++) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow++] = nums[fast];
                }
            }

            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
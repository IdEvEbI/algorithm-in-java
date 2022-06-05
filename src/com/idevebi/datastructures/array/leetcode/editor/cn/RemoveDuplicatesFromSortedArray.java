package com.idevebi.datastructures.array.leetcode.editor.cn;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();

        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            // 删除完重复元素的长度
            int len = 0;

            // 从第 1 项元素开始遍历数组
            for (int i = 1; i < nums.length; i++) {

                // 如果与前面一项元素不同
                if (nums[i] != nums[len]) {
                    nums[++len] = nums[i];
                }
            }

            return len + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
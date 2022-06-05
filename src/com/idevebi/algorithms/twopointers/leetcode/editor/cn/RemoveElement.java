package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

/**
 * 27. 移除元素
 */
public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();

        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         * <p>
         * left 指针记录移除元素后的数组大小
         * right 从数组末尾开始，把数组末尾的值，移动到前面
         */
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                if (nums[left] == val) {
                    nums[left] = nums[right--];
                } else {
                    left++;
                }
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
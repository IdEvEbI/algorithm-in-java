package com.idevebi.datastructures.array.leetcode.editor.cn;

/**
 * 35. 搜索插入位置
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();

        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int ans = nums.length;

            while (left <= right) {
                int idx = left + (right - left) / 2;

                if (nums[idx] >= target) {
                    ans = idx;
                    right = idx - 1;
                } else {
                    left = idx + 1;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
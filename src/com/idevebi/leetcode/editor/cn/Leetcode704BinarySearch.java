package com.idevebi.leetcode.editor.cn;

public class Leetcode704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Leetcode704BinarySearch().new Solution();

        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(solution.search(new int[]{5}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                // 取数组的中间索引
                int idx = left + (right - left) / 2;
                int mid = nums[idx];

                // 如果 mid == target 直接返回
                if (mid == target) {
                    return idx;
                } else if (mid > target) {
                    right = idx - 1;
                } else {
                    left = idx + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
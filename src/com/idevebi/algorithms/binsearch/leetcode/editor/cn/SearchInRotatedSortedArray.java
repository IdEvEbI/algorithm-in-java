package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/">https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/</a>
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();

        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[0] > target ^ nums[0] > nums[mid] ^ target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left == right && nums[left] == target ? left : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
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
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return searchWithBinSearch(nums, target);
        }

        /**
         * 方法 2：直接用二分查找（好理解）
         * <p>
         * 提示：旋转数组后，一定有一边是有序的
         */
        private int searchWithBinSearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                // 右边有序
                if (nums[mid] < nums[right]) {
                    // 目标值在右边
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // 目标值在左边
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return -1;
        }

        /**
         * 方法 1：使用异或判断条件（代码简介，但是不好理解）
         */
        private int searchWithXor(int[] nums, int target) {
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
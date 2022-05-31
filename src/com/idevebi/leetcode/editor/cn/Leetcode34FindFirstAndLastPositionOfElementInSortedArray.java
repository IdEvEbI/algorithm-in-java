package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Leetcode34FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        int[] ans = solution.searchRange(new int[]{}, -1);
        System.out.println(Arrays.toString(ans));

        ans = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(ans));

        ans = solution.searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ans));

        ans = solution.searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ans));

        ans = solution.searchRange(new int[]{8, 8, 8, 8, 8, 8, 8}, 8);
        System.out.println(Arrays.toString(ans));

        ans = solution.searchRange(new int[]{5, 7, 8, 10}, 7);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 用二分法查找左侧和右侧第一次出现的索引
            int left = binarySearch(nums, target, true);
            int right = binarySearch(nums, target, false);

            if (left <= right) {
                return new int[]{left, right};
            }

            return new int[]{-1, -1};
        }

        private int binarySearch(int[] nums, int target, boolean fromLeft) {
            int len = nums.length - 1;
            int left = 0;
            int right = len;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    // 如果是从左遍历，想做继续查找相等的值
                    while (fromLeft && mid >= 0 && nums[mid] == target) {
                        mid--;
                    }
                    while (!fromLeft && mid <= len && nums[mid] == target) {
                        mid++;
                    }
                    return fromLeft ? mid + 1 : mid - 1;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
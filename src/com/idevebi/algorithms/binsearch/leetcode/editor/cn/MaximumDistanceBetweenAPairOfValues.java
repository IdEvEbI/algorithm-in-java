package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

/**
 * 1855. 下标对中的最大距离
 */
public class MaximumDistanceBetweenAPairOfValues {
    public static void main(String[] args) {
        Solution solution = new MaximumDistanceBetweenAPairOfValues().new Solution();

        System.out.println(solution.maxDistance(new int[]{55, 30, 5, 4, 2},
                new int[]{100, 20, 10, 10, 5}));
        System.out.println(solution.maxDistance(new int[]{2, 2, 2},
                new int[]{10, 10, 1}));
        System.out.println(solution.maxDistance(new int[]{30, 29, 19, 5},
                new int[]{25, 25, 25, 25, 25}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxDistance(int[] nums1, int[] nums2) {
            return maxDistanceWithPoints(nums1, nums2);
        }

        /**
         * 方法 2：双指针优化
         */
        private int maxDistanceWithPoints(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int left = 0;
            int right = 0;

            while (left < len1 && right < len2) {
                if (nums1[left] > nums2[right]) {
                    left++;
                }
                right++;
            }

            return Math.max(right - left - 1, 0);
        }

        /**
         * 方法 1：双指针模拟
         */
        private int maxDistanceWithTwoPoints(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int ans = 0;

            for (int i = 0, j = 0; i < len1 && j < len2; i++) {
                while (j < len2) {
                    if (nums2[j] >= nums1[i]) {
                        j++;
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, j - i - 1);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
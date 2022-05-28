package com.idevebi.leetcode.editor.cn;

public class Leetcode852PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new Leetcode852PeakIndexInAMountainArray().new Solution();

        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 4, 5, 9, 10, 5, 2}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{24, 69, 77, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用二分查找，找到数组中的最大值索引
         */
        public int peakIndexInMountainArray(int[] arr) {
            int left = 1;
            int right = arr.length - 2;
            int ans = 0;

            while (left <= right) {
                int idx = left + (right - left) / 2;

                // 后面的值比前面的值小，向前找（缩小 right）
                if (arr[idx] > arr[idx + 1]) {
                    ans = idx;
                    right = idx - 1;
                } else {
                    // 向后找（增大 left）
                    left = idx + 1;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
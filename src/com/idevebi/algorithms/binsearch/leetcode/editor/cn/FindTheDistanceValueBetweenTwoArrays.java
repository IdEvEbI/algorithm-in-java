package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 */
public class FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        Solution solution = new FindTheDistanceValueBetweenTwoArrays().new Solution();

        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {-4, -3, 6, 10, 20, 30};
        System.out.println(solution.findTheDistanceValue(arr1, arr2, 3));

        arr1 = new int[]{4, 5, 8};
        arr2 = new int[]{10, 9, 1, 8};
        System.out.println(solution.findTheDistanceValue(arr1, arr2, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1： 模拟优化（思路好理解）
         */
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int count = 0;

            for (int x : arr1) {
                if (isOk(x, arr2, d)) {
                    count++;
                }
            }

            return count;
        }

        private boolean isOk(int x, int[] arr2, int d) {
            for (int y : arr2) {
                if (Math.abs(x - y) <= d) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 方法 2：二分查找（不好理解，代码也比较复杂）
         */
        public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
            int count = 0;

            // 1. 对 arr2 排序
            Arrays.sort(arr2);

            // 遍历数组
            for (int x : arr1) {
                // 2. 在 arr2 中查找第一个比 x 大的索引
                int p = binarySearch(arr2, x);

                // 3. 比较前后两个值
                boolean flag = p >= arr2.length || arr2[p] - x > d;

                if (p - 1 >= 0 && x - arr2[p - 1] <= d) {
                    flag = false;
                }

                // 4. 更新计数
                count += flag ? 1 : 0;
            }

            return count;
        }

        private int binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;

            if (arr[right] < target) {
                return right + 1;
            }

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        /**
         * 方法 3：模拟
         */
        public int findTheDistanceValue3(int[] arr1, int[] arr2, int d) {
            int count = 0;

            for (int x : arr1) {
                boolean flag = true;
                // 遍历 arr2，只要有一个值不是距离值，flag 为 false
                for (int y : arr2) {
                    if (Math.abs(x - y) <= d) {
                        flag = false;
                        break;
                    }
                }
                // 更新计数
                count += flag ? 1 : 0;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
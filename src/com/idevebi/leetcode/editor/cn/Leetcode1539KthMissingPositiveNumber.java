package com.idevebi.leetcode.editor.cn;

public class Leetcode1539KthMissingPositiveNumber {
    public static void main(String[] args) {
        Solution solution = new Leetcode1539KthMissingPositiveNumber().new Solution();

        System.out.println(solution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
        System.out.println(solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 2：二分法
         * <p>
         * 公式：值 - 索引 - 1 = k
         * 数组：{2, 3, 4, 7, 11}
         * 索引： 0  1  2  3  4
         * 结果(k)： 1  1  1  3  6
         * <p>
         * 思路：
         * 1. 转换公式：索引 + 1 + k = 目标值
         * 2. 检查数组末尾，避免数组越界
         * 3. 用二分法找到最接近的 索引(left)
         * 4. 返回 left + 1 + k
         */
        public int findKthPositive(int[] arr, int k) {
            int left = 0;
            int right = arr.length - 1;
            int len = arr.length;

            // 检查最后一个元素
            if (arr[len - 1] - len < k) {
                return k + len;
            }

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] - mid - 1 < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left + k;
        }

        /**
         * 方法 1：暴力枚举
         */
        public int findKthPositive2(int[] arr, int k) {
            // 目标数，初始为 -1
            int target = -1;

            // value: 严格升序的整数，1, 2, 3, 4, 5 ~ ...
            // miss: 缺失计数
            // i: 数组下标
            for (int value = 1, miss = 0, i = 0; miss < k; value++) {
                // 如果当前计数 和 数组下标一致
                if (value == arr[i]) {
                    // 防止越界
                    i = (i + 1 < arr.length) ? i + 1 : i;
                } else {
                    miss++;
                    target = value;
                }
            }

            return target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
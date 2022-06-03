package com.idevebi.leetcode.editor.cn;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class OfferShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new OfferShuZuZhongDeNiXuDuiLcof().new Solution();

        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：归并排序，每次归并时统计一下逆序对即可
         */
        public int reversePairs(int[] nums) {
            int len = nums.length;

            if (len < 2) {
                return 0;
            }

            int[] temp = new int[len];
            return reversePairs(nums, 0, len - 1, temp);
        }

        private int reversePairs(int[] nums, int left, int right, int[] temp) {
            if (left >= right) {
                return 0;
            }

            int mid = left + (right - left) / 2;

            int leftPairs = reversePairs(nums, left, mid, temp);
            int rightPairs = reversePairs(nums, mid + 1, right, temp);

            if (nums[mid] <= nums[mid + 1]) {
                return leftPairs + rightPairs;
            }

            int mergePairs = merge(nums, left, mid, right, temp);

            return leftPairs + rightPairs + mergePairs;
        }

        private int merge(int[] nums, int left, int mid, int right, int[] temp) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);

            int i = left;
            int j = mid + 1;

            int count = 0;
            for (int k = left; k <= right; k++) {

                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {
                    nums[k] = temp[i];
                    i++;
                } else {
                    nums[k] = temp[j];
                    j++;
                    count += (mid - i + 1);
                }
            }
            return count;
        }

        /**
         * 方法 2：暴力解法
         * <p>
         * 时间复杂度 O(n^2) （提交不通过）
         */
        public int reversePairs2(int[] nums) {
            int len = nums.length;
            int count = 0;

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] > nums[j]) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
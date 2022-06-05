package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();

        int[] ans = solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(Arrays.toString(ans));

        ans = solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力解法
         */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[] ans = new int[len1];

            // 遍历 nums1
            for (int i = 0; i < len1; i++) {
                int j = 0;

                // 在 nums2 中查找 nums[i] 所在位置
                while (j < len2 && nums2[j] != nums1[i]) {
                    j++;
                }

                // 继续向后找到 下一个更大的元素
                int k = j + 1;
                while (k < len2 && nums2[k] < nums1[i]) {
                    k++;
                }

                // 填充结果数组
                ans[i] = k < len2 ? nums2[k] : -1;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
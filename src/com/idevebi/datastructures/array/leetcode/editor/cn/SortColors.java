package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();

        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         */
        public void sortColors(int[] nums) {
            int len = nums.length;

            int left = 0;
            int right = len - 1;

            // 从左向右扫描数组
            for (int i = 0; i <= right; i++) {
                // 如果连续遇到蓝色，循环移动到数组末尾，缩小右指针
                while (i <= right && nums[i] == 2) {
                    int tmp = nums[i];
                    nums[i] = nums[right];
                    nums[right--] = tmp;
                }
                // 如果连续遇到红色，移动到数组开始，增加左指针
                // Tip 因为 i 是从左向右扫描，红色不需要循环
                if (nums[i] == 0) {
                    if (i != left) {
                        int tmp = nums[i];
                        nums[i] = nums[left];
                        nums[left] = tmp;
                    }
                    left++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.algorithms.sort.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();

        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针，一个记录数组索引，一个记录非零元素索引
         */
        public void moveZeroes(int[] nums) {
            // 记录非零元素索引
            int idx = 0;

            // 遍历数组
            for (int i = 0; i < nums.length; i++) {
                // 如果元素不为 0，将元素移动到 idx 位置，同时 idx++
                if (nums[i] != 0) {

                    if (i != idx) {
                        nums[idx] = nums[i];
                        nums[i] = 0;
                    }

                    idx++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
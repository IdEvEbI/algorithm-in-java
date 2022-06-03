package com.idevebi.algorithms.sort.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();

        System.out.println(solution.minNumber(new int[]{10, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：使用 排序 API
         *
         * 提示：哪一个元素排在前面使得最终拼接的数值最小，例如 [3, 30] → [30, 3]
         */
        public String minNumber(int[] nums) {
            // 1. 将数字数组转成字符串数组
            String[] strs = new String[nums.length];

            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }

            // 2. 排序字符串
            Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));

            // 3. 拼接结果并返回
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s);
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
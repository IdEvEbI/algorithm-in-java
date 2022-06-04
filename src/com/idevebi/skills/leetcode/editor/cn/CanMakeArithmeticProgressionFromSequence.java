package com.idevebi.skills.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 */
public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        Solution solution = new CanMakeArithmeticProgressionFromSequence().new Solution();

        System.out.println(solution.canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(solution.canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            // 1. 数组排序
            Arrays.sort(arr);

            // 2. 遍历数组
            int step = arr[1] - arr[0];
            int len = arr.length;
            for (int i = 2; i < len; i++) {
                if (arr[i] - arr[i - 1] != step) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new Leetcode167TwoSumIiInputArrayIsSorted().new Solution();

        int[] ans = solution.twoSum(new int[]{2, 7, 11, 15}, 22);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.skills.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * <p>
 * 解题思路：
 * 1. 看到「最大」首先想到贪心或动态规划，而题目不需要推导动态方程，选择而贪心
 * 2. 题目规则可以看到，数组元素会有很多并且没有排序，而要选择周长最大，则先做排序
 */
public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        Solution solution = new LargestPerimeterTriangle().new Solution();

        System.out.println(solution.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(solution.largestPerimeter(new int[]{1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPerimeter(int[] nums) {
            // 1. 数组排序
            Arrays.sort(nums);

            // 2. 从数组末尾遍历，找到满足构成三角形的条件的三条边
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i - 2] + nums[i - 1] > nums[i]) {
                    return nums[i - 2] + nums[i - 1] + nums[i];
                }
            }

            // 3. 没有找到符合条件的边，返回 0
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
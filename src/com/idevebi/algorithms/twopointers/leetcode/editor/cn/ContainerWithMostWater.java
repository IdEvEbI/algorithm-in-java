package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

/**
 * 11. 盛最多水的容器
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();

        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max = 0;

            // 遍历数组
            while (left < right) {
                // 使用 小的高度 * 宽 计算面积
                int minHeight = Math.min(height[left], height[right]);
                int area = minHeight * (right - left);

                // 更新最大面积值
                max = Math.max(max, area);

                // 关键点：跳过低木板
                while (height[left] <= minHeight && left < right) {
                    left++;
                }
                while (height[right] <= minHeight && left < right) {
                    right--;
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
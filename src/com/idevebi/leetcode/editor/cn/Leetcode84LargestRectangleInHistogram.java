package com.idevebi.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new Leetcode84LargestRectangleInHistogram().new Solution();

        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution.largestRectangleArea(new int[]{2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：单调栈
         */
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;

            // 左右边界数组
            int[] left = new int[len];
            int[] right = new int[len];
            Arrays.fill(right, len);

            // 定义单调栈（只允许递增入栈）
            Deque<Integer> stack = new ArrayDeque<>();

            // 遍历数组
            for (int i = 0; i < len; i++) {
                // 3. 如果栈不为空，寻找右边界
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    right[stack.peek()] = i;
                    stack.pop();
                }

                // 1. 如果栈为空，left = -1
                left[i] = stack.isEmpty() ? -1 : stack.peek();

                // 2. 数据入栈
                stack.push(i);
            }

            // 4. 计算最大面积
            int max = 0;
            for (int i = 0; i < len; i++) {
                max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
            }

            return max;
        }

        /**
         * 方法 2：暴力解法，双重 for 循环
         * <p>
         * 思路很简单，不过超出时间限制
         */
        public int largestRectangleArea2(int[] heights) {
            int len = heights.length;
            int max = 0;

            // 1. 从左向右遍历数组
            for (int left = 0; left < len; left++) {
                // 最小高度
                int minHeight = Integer.MAX_VALUE;

                // 2. 从当前位置向右遍历，并计算面积
                for (int right = left; right < len; right++) {
                    // 找到最小高度
                    minHeight = Math.min(minHeight, heights[right]);

                    // 更新最大面积
                    max = Math.max(max, (right - left + 1) * minHeight);
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Leetcode42TrappingRainWater().new Solution();

        System.out.println(solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：双指针
         */
        public int trap(int[] height) {
            // 左右指针
            int left = 0;
            int right = height.length - 1;
            // 左右柱子最大高度
            int leftMax = 0;
            int rightMax = 0;
            // 结果
            int ans = 0;

            while (left < right) {
                // 更新左右柱子最大高度
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);

                // 如果左边柱子没有右边柱子高，递增左指针
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    left++;
                } else {
                    ans += rightMax - height[right];
                    right--;
                }
            }

            return ans;
        }

        /**
         * 方法 2：单调递减栈，只需要扫描 1 次数组
         */
        public int trap2(int[] height) {
            int ans = 0;
            int n = height.length;

            // 递减栈
            Deque<Integer> stack = new ArrayDeque<>();

            // 从左向右扫描数组
            for (int i = 0; i < n; i++) {

                // 2. 处理递减栈，栈顶元素高度大于后续元素的高度
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // 2.1 左侧柱子的高度（当前最矮的一根）
                    int top = stack.pop();

                    // 2.2 继续检查左侧的柱子，获得前一项索引
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();

                    // 2.3 计算宽度
                    int w = i - left - 1;
                    // 2.4 计算高度
                    int h = Math.min(height[left], height[i]) - height[top];

                    // 2.5 计算面积更新结果
                    ans += w * h;
                }

                // 1. 数字索引入栈
                stack.push(i);
            }

            return ans;
        }

        /**
         * 方法 3：动态规划，需要扫描 3 次数组
         */
        public int trap3(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }

            // 从左向右扫描的最大值数组
            int[] leftMax = new int[n];
            // 从右向左扫描的最大值数组
            int[] rightMax = new int[n];

            // 1. 从左向右扫描，生成向右的最大值数组
            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            // 2. 从右向左扫描，生成向左的最大值数组
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            // 3. 扫描两个数组，计算面积
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
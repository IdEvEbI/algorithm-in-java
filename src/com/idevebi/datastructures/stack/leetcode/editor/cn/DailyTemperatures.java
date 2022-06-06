package com.idevebi.datastructures.stack.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/">https://leetcode.cn/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/</a>
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();

        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = solution.dailyTemperatures(nums);

        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调栈（递减）
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] ans = new int[len];

            // 单调栈
            // 注：Stack 143 ms / Deque 22 ms
            // Stack<Integer> stack = new Stack<>();
            Deque<Integer> stack = new LinkedList<>();

            // 遍历数组
            for (int i = 0; i < len; i++) {
                // 2. 处理栈
                // 如果栈不为空 同时 当前元素的温度高于栈顶高度
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    // 出栈
                    int t = stack.pop();
                    // 计算间隔天数
                    ans[t] = i - t;
                }

                // 1. 把数据"索引"入栈
                stack.push(i);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
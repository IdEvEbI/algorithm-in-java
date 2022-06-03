package com.idevebi.algorithmsBak.datastructures.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 每日温度
 *
 * <a href="https://leetcode.cn/problems/daily-temperatures/">https://leetcode.cn/problems/daily-temperatures/</a>
 */
public class LC739DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(ans));
    }

    /**
     * 参考视频：
     *
     * <a href="https://leetcode.cn/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/">https://leetcode.cn/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/</a>
     */
    private static int[] dailyTemperatures(int[] temperatures) {
        // 结果数组
        int[] res = new int[temperatures.length];
        // 定义栈
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // 遍历数组
        for (int i = 0; i < temperatures.length; i++) {
            // 处理栈，如果栈不为空，同时当前的温度比栈顶高
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 出栈
                int t = stack.pop();
                // 计算间隔天数
                res[t] = i - t;
            }
            // 把数组索引入栈
            stack.push(i);
        }

        return res;
    }
}

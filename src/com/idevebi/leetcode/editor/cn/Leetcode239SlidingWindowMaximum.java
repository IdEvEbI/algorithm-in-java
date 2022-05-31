package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Leetcode239SlidingWindowMaximum().new Solution();

        int[] res = solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        System.out.println(Arrays.toString(res));

        res = solution.maxSlidingWindow(new int[]{7, 2, 4}, 2);
        System.out.println(Arrays.toString(res));

        res = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用双端队列，队列左侧始终保持当前窗口中的最大值
         */
        public int[] maxSlidingWindow(int[] nums, int k) {

            int len = nums.length;
            int[] res = new int[len - k + 1];

            Deque<Integer> q = new LinkedList<>();

            // 遍历数组
            for (int i = 0; i < len; i++) {

                // 2. 如果队列不为空，判断当前入队的值，是否比左侧的值大
                while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    // 弹出之前的值
                    q.pollLast();
                }

                // 1. 索引入队
                q.offerLast(i);

                // 4. 判断索引是否离开窗口
                if (!q.isEmpty() && q.peek() <= i - k) {
                    q.poll();
                }

                // 3. 如果 k < 1，说明窗口已经装满
                if (i + 1 >= k) {
                    // 将左侧最大值添加到结果数组
                    res[i + 1 - k] = nums[q.peek()];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
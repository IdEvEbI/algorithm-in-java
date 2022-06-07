package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 */
public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();

        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            return kWeakesWithPQ(mat, k);
        }

        /**
         * 方法 2：二分 + 优先队列
         */
        private int[] kWeakesWithPQ(int[][] mat, int k) {
            // 1. 定义优先队列（按照战斗力[0] + 索引[1] 排序的优先队列）
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });

            // 2. 二分查找计算战斗力
            int width = mat[0].length;
            int height = mat.length;

            for (int row = 0; row < height; row++) {
                int l = 0;
                int r = width - 1;

                while (l < r) {
                    int mid = l + (r - l) / 2 + 1;
                    if (mat[row][mid] >= 1) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                int power = mat[row][r] >= 1 ? r + 1 : r;

                // 加入优先队列
                pq.offer(new int[]{power, row});
            }

            // 3. 填充结果数组
            int[] ans = new int[k];
            for (int i = 0; i < k && !pq.isEmpty(); i++) {
                ans[i] = pq.poll()[1];
            }

            return ans;
        }

        /**
         * 方法 1：暴力解法（累加 + 排序）
         */
        private int[] bruteForce(int[][] mat, int k) {
            int width = mat[0].length;
            int height = mat.length;

            // 遍历矩阵填充战斗力数组
            int[][] power = new int[height][2];
            for (int row = 0; row < height; row++) {
                int count = 0;
                for (int col : mat[row]) {
                    count += col;
                }
                power[row] = new int[]{count, row};
            }

            // 按战斗力 + 索引升序排序
            Arrays.sort(power, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            // 填充结果数组
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = power[i][1];
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
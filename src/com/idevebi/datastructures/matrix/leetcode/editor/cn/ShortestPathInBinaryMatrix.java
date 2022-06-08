package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/solution/bfszui-duan-lu-jing-wen-ti-bfsdfsde-si-k-ngc5/">https://leetcode.cn/problems/shortest-path-in-binary-matrix/solution/bfszui-duan-lu-jing-wen-ti-bfsdfsde-si-k-ngc5/</a>
 * 参考资料：<a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/solution/bfsa-qi-fa-sou-suo-duo-chong-fang-fa-you-jrqp/">https://leetcode.cn/problems/shortest-path-in-binary-matrix/solution/bfsa-qi-fa-sou-suo-duo-chong-fang-fa-you-jrqp/</a>
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();

        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid));

        grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid));

        grid = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方向定义：左、右、上、下、左上、左下、右上、右下
         */
        private static final int[][] dirs = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        public int shortestPathBinaryMatrix(int[][] grid) {
            // 地图是正方形的
            int n = grid.length;

            // 判断左上、右下是否为 1（堵死）
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
                return -1;
            }

            // BFS 的队列[r, c, 步数]
            Queue<int[]> queue = new ArrayDeque<>();
            // 起始点入队
            queue.offer(new int[]{0, 0, 1});

            // 开始寻路，走过的点标记为 1，避免重复
            grid[0][0] = 1;

            while (!queue.isEmpty()) {
                int[] data = queue.poll();
                int r = data[0];
                int c = data[1];
                int step = data[2];

                // 如果已经走到右下角，直接返回步数
                if (r == n - 1 && c == n - 1) {
                    return step;
                }

                // 朝 8 个方向扫描
                for (int[] dir : dirs) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) {
                        grid[row][col] = 1;
                        queue.offer(new int[]{row, col, step + 1});
                    }
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
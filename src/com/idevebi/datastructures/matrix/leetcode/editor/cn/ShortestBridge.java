package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. 最短的桥
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/shortest-bridge/solution/bfs-tian-hai-zao-lu-ti-jie-si-lu-by-carp-6w8j/">https://leetcode.cn/problems/shortest-bridge/solution/bfs-tian-hai-zao-lu-ti-jie-si-lu-by-carp-6w8j/</a>
 */
public class ShortestBridge {
    public static void main(String[] args) {
        Solution solution = new ShortestBridge().new Solution();

        int[][] grid = {
                {0, 1},
                {1, 0}
        };
        System.out.println(solution.shortestBridge(grid));

        grid = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(solution.shortestBridge(grid));

        grid = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(solution.shortestBridge(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方向定义：左、右、上、下
         */
        private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /**
         * 宽、高
         */
        private int width, height;
        /**
         * BFS 搜索队列
         */
        Queue<int[]> queue;

        /**
         * 先用 DFS 找到岛，再用 BFS 找桥
         */
        public int shortestBridge(int[][] grid) {
            width = grid[0].length;
            height = grid.length;
            queue = new LinkedList<>();

            // 1. 先用 dfs 找到第一个岛，并且把数值改为 2
            boolean finished = false;
            for (int r = 0; r < height && !finished; r++) {
                for (int c = 0; c < width; c++) {
                    if (grid[r][c] == 1) {
                        // 把岛屿标记成 2，并且把周围的水添加到 queue
                        dfs(grid, r, c);
                        finished = true;
                        break;
                    }
                }
            }

            // 2. bfs 找到下一个岛
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;

                while (size-- > 0) {
                    int[] point = queue.poll();

                    for (int[] dir : dirs) {
                        int r = point[0] + dir[0];
                        int c = point[1] + dir[1];

                        if (r >= 0 && r < height && c >= 0 && c < width) {
                            // 找到了第 2 个岛
                            if (grid[r][c] == 1) {
                                return count;
                            } else if (grid[r][c] == 2) {
                                continue;
                            }
                            // 扫描过的位置添加标记
                            grid[r][c] = 2;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] grid, int r, int c) {
            grid[r][c] = 2;

            for (int[] dir : dirs) {
                int row = r + dir[0];
                int col = c + dir[1];

                if (row >= 0 && row < height && col >= 0 && col < height) {
                    // 将岛屿周围的水域填入队列，方便后续做 BFS
                    if (grid[row][col] == 0) {
                        queue.offer(new int[]{row, col});
                    }
                    if (grid[row][col] == 1) {
                        dfs(grid, row, col);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            return numIslandsDFS(grid);
        }

        /**
         * 方法 2：DFS 递归（速度会比 BFS + Queue 快很多）
         */
        private int numIslandsDFS(char[][] grid) {
            // 基础定义
            int w = grid[0].length;
            int h = grid.length;
            // 岛屿数量
            int count = 0;

            // 遍历数组
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (grid[r][c] == '1') {
                        count++;

                        // 用深度优先搜索当前坐标所在的岛屿
                        dfs(grid, r, c, w, h);
                    }
                }
            }

            return count;
        }

        private void dfs(char[][] grid, int r, int c, int w, int h) {
            if (r < 0 || c < 0 || r >= h || c >= w || grid[r][c] == '0') {
                return;
            }

            // 将岛屿"摧毁" → 水
            grid[r][c] = '0';
            dfs(grid, r, c - 1, w, h);
            dfs(grid, r + 1, c, w, h);
            dfs(grid, r, c + 1, w, h);
            dfs(grid, r - 1, c, w, h);
        }

        /**
         * 方法 1：BFS（提示：如果把 bfs 独立出去，在提交时容易超时）
         */
        private int numIslandsBFS(char[][] grid) {
            // 基础定义
            int w = grid[0].length;
            int h = grid.length;
            // 岛屿数量
            int count = 0;

            // 遍历数组
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    // 如果遇到水，继续遍历
                    if (grid[r][c] == '0') {
                        continue;
                    }
                    // 将岛屿"摧毁" → 水
                    grid[r][c] = '0';

                    // 用广度优先搜索当前坐标所在的岛屿
                    Queue<Integer> q = new LinkedList<>();

                    // 1. 坐标值入队：行 * 宽度 + 列
                    q.offer(r * w + c);

                    // 2. BFS
                    while (!q.isEmpty()) {
                        // 坐标值出队并计算宽高
                        int coor = q.poll();
                        int row = coor / w;
                        int col = coor % w;

                        // 遍历 4 个方向
                        for (int[] dir : new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}}) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if (nr >= 0 && nr < h && nc >= 0 && nc < w && grid[nr][nc] == '1') {
                                q.offer(nr * w + nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }

                    // 计数 +1
                    count++;
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
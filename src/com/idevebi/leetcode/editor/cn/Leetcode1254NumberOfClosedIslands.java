package com.idevebi.leetcode.editor.cn;

public class Leetcode1254NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new Leetcode1254NumberOfClosedIslands().new Solution();

        int[][] grid = {
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0}
        };
        System.out.println(solution.closedIsland(grid));

        grid = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid));

        grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid));

        grid = new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1}
        };
        System.out.println(solution.closedIsland(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：DFS + 递归 + 问题转化
         * <p>
         * 1. 先扫描左右两列和上下两行，把所有与边相邻的 0（土地）转换成1（水）
         * 2. 转换之后，问题就和 200 题（岛屿的数量）完全一样
         */
        public int closedIsland(int[][] grid) {
            int w = grid[0].length;
            int h = grid.length;

            // 扫描左右两列
            for (int r = 0; r < h; r++) {
                dfs(grid, r, 0, w, h);
                dfs(grid, r, w - 1, w, h);
            }

            // 扫描上下两行
            for (int c = 0; c < w; c++) {
                dfs(grid, 0, c, w, h);
                dfs(grid, h - 1, c, w, h);
            }

            // 封闭岛屿数量
            int count = 0;

            // 扫描完整地图
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (grid[r][c] == 0) {
                        dfs(grid, r, c, w, h);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int r, int c, int w, int h) {
            if (r < 0 || c < 0 || r >= h || c >= w || grid[r][c] == 1) {
                return;
            }

            grid[r][c] = 1;
            dfs(grid, r - 1, c, w, h);
            dfs(grid, r + 1, c, w, h);
            dfs(grid, r, c - 1, w, h);
            dfs(grid, r, c + 1, w, h);
        }

        /**
         * 方法 2：DFS + 递归
         */
        public int closedIsland2(int[][] grid) {
            int w = grid[0].length;
            int h = grid.length;

            // 封闭岛屿数量
            int count = 0;

            // 判断 grid 大小能否围成岛屿（阅读题目规则）
            if (w <= 2 || h <= 2) {
                return 0;
            }

            // 遍历 grid，由于是封闭岛屿，不需要遍历边界
            for (int r = 1; r < h - 1; r++) {
                for (int c = 1; c < w - 1; c++) {
                    // 遇到陆地
                    if (grid[r][c] == 0) {
                        // 判断当前坐标所在位置是否是封闭岛屿
                        if (dfs2(grid, r, c, w, h)) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }

        private boolean dfs2(int[][] grid, int r, int c, int w, int h) {
            // 1. 如果处于边界，同时是土地，则不是岛屿
            if ((r == 0 || r == h - 1 || c == 0 || c == w - 1) && grid[r][c] == 0) {
                return false;
            }

            // 2. 是否是岛屿标记
            boolean isLand = true;
            // 当前位置标记成水，避免重复遍历
            grid[r][c] = 1;

            // 3. 遍历 4 个方向
            for (int[] dir : new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}}) {
                int row = r + dir[0];
                int col = c + dir[1];

                // 如果新坐标不符合条件，则不需要递归
                if (row >= 0 && row < h && col >= 0 && col < w && grid[row][col] == 0) {
                    isLand = isLand & dfs2(grid, row, col, w, h);
                }
            }

            return isLand;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
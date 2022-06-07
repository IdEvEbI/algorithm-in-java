package com.idevebi.datastructures.matrix.leetcode.editor.cn;

/**
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0}};

        System.out.println(solution.maxAreaOfIsland(grid));

        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * DFS + 递归
         */
        public int maxAreaOfIsland(int[][] grid) {
            int w = grid[0].length;
            int h = grid.length;
            // 最大面积
            int maxArea = 0;

            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (grid[r][c] == 1) {
                        // 用深度优先计算该岛屿的面积并返回
                        int area = dfs(grid, r, c, w, h);

                        maxArea = Math.max(maxArea, area);
                    }
                }
            }

            return maxArea;
        }

        private int dfs(int[][] grid, int r, int c, int w, int h) {
            if (r < 0 || c < 0 || r >= h || c >= w || grid[r][c] != 1) {
                return 0;
            }

            int area = 1;

            // 修改岛屿标记，避免重复扫描
            grid[r][c] = 2;
            area += dfs(grid, r, c - 1, w, h);
            area += dfs(grid, r + 1, c, w, h);
            area += dfs(grid, r, c + 1, w, h);
            area += dfs(grid, r - 1, c, w, h);

            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
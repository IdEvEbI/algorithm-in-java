package com.idevebi.datastructures.matrix.leetcode.editor.cn;

/**
 * 1020. 飞地的数量
 */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();

        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(solution.numEnclaves(grid));

        grid = new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(solution.numEnclaves(grid));
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
         * 能否访问边界标记
         */
        private boolean[][] visited;

        /**
         * 问题转化：不与边界相邻的陆地数量
         */
        public int numEnclaves(int[][] grid) {
            width = grid[0].length;
            height = grid.length;
            visited = new boolean[height][width];

            // 1. 扫描与左右两条边相邻的陆地（能够到达边界的 visited 标记为 true）
            for (int r = 0; r < height; r++) {
                dfs(grid, r, 0);
                dfs(grid, r, width - 1);
            }
            // 2. 扫描与上下两条边相邻的陆地（能够到达边界的 visited 标记为 true）
            for (int c = 1; c < width - 1; c++) {
                dfs(grid, 0, c);
                dfs(grid, height - 1, c);
            }
            // 3. 重新扫描地图，汇总 访问标记为 false 的陆地（不扫描边）
            int count = 0;
            for (int r = 1; r <= height - 1; r++) {
                for (int c = 1; c < width - 1; c++) {
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] grid, int r, int c) {
            if (r < 0 || c < 0 || r >= height || c >= width || grid[r][c] == 0 || visited[r][c]) {
                return;
            }

            visited[r][c] = true;

            for (int[] dir : dirs) {
                dfs(grid, r + dir[0], c + dir[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
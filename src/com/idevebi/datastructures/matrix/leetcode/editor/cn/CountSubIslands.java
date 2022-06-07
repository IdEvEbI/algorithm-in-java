package com.idevebi.datastructures.matrix.leetcode.editor.cn;

/**
 * 1905. 统计子岛屿
 */
public class CountSubIslands {
    public static void main(String[] args) {
        Solution solution = new CountSubIslands().new Solution();

        int[][] grid1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        int[][] grid2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };
        System.out.println(solution.countSubIslands(grid1, grid2));

        grid1 = new int[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };
        grid2 = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        System.out.println(solution.countSubIslands(grid1, grid2));

        grid1 = new int[][]{
                {1, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        grid2 = new int[][]{
                {1, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0}
        };
        System.out.println(solution.countSubIslands(grid1, grid2));
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

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            width = grid1[0].length;
            height = grid1.length;

            // 1. 用地图 1 是海水 的位置填充地图 2
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (grid1[r][c] == 0 && grid2[r][c] == 1) {
                        dfs(grid2, r, c);
                    }
                }
            }

            // 2. 再次扫描地图 2
            int count = 0;

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (grid2[r][c] == 1) {
                        count++;
                        dfs(grid2, r, c);
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] grid, int r, int c) {
            if (r < 0 || r >= height || c < 0 || c >= width || grid[r][c] == 0) {
                return;
            }

            grid[r][c] = 0;

            boolean res = true;
            for (int[] dir : dirs) {
                dfs(grid, r + dir[0], c + dir[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
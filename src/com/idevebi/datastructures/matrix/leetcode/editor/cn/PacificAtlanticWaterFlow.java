package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * <p>
 * 提示：分别从 太平洋 和 大西洋 逆向搜索岛屿的最高点，否则需要遍历的点会太多
 */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(solution.pacificAtlantic(heights));
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
         * 高度数组
         */
        private int[][] heights;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;

            width = heights[0].length;
            height = heights.length;

            // 能够流到 太平洋 和 大西洋 的坐标
            boolean[][] pacific = new boolean[height][width];
            boolean[][] atlantic = new boolean[height][width];

            // 1. 从太平洋扫描（左上）
            for (int r = 0; r < height; r++) {
                dfs(r, 0, pacific);
            }
            for (int c = 0; c < width; c++) {
                dfs(0, c, pacific);
            }
            // 2. 从大西洋扫描（右下）
            for (int r = 0; r < height; r++) {
                dfs(r, width - 1, atlantic);
            }
            for (int c = 0; c < width; c++) {
                dfs(height - 1, c, atlantic);
            }

            // 3. 建立交集（既能流入太平洋，又能流入大西洋）
            List<List<Integer>> ans = new ArrayList<>();
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (pacific[r][c] && atlantic[r][c]) {
                        List<Integer> p = new ArrayList<>();

                        p.add(r);
                        p.add(c);

                        ans.add(p);
                    }
                }
            }

            return ans;
        }

        private void dfs(int r, int c, boolean[][] ocean) {
            // 如果已经标记过，直接返回
            if (ocean[r][c]) {
                return;
            }
            // 添加标记
            ocean[r][c] = true;

            // 向四个方向扫描，但是只想高的方向扫描（水倒流）
            for (int[] dir : dirs) {
                int row = r + dir[0];
                int col = c + dir[1];

                if (row >= 0 && row < height && col >= 0 && col < width && heights[row][col] >= heights[r][c]) {
                    dfs(row, col, ocean);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
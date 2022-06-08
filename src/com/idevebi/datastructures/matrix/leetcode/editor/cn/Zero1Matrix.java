package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/">https://leetcode.cn/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/</a>
 */
public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();

        int[][] mat = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        mat = solution.updateMatrix(mat);
        printMatrix(mat);

        mat = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };
        mat = solution.updateMatrix(mat);
        printMatrix(mat);
    }

    private static void printMatrix(int[][] mat) {
        for (int[] m : mat) {
            System.out.println(Arrays.toString(m));
        }
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

        public int[][] updateMatrix(int[][] mat) {
            width = mat[0].length;
            height = mat.length;

            // 1. 扫描 mat，将所有 0 边上的 1 入队
            int[][] ans = new int[height][width];
            Queue<int[]> queue = new ArrayDeque<>();

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (mat[r][c] == 0) {
                        for (int[] dir : dirs) {
                            int row = r + dir[0];
                            int col = c + dir[1];

                            if (row >= 0 && row < height && col >= 0 && col < width
                                    && mat[row][col] == 1 && ans[row][col] == 0) {
                                ans[row][col] = 1;
                                queue.offer(new int[]{row, col});
                            }
                        }
                    }
                }
            }

            // 2. BFS 扫描
            while (!queue.isEmpty()) {
                int[] point = queue.poll();

                for (int[] dir : dirs) {
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];

                    if (r >= 0 && r < height && c >= 0 && c < width
                            && mat[r][c] == 1 && ans[r][c] == 0) {
                        ans[r][c] = ans[point[0]][point[1]] + 1;
                        queue.offer(new int[]{r, c});
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
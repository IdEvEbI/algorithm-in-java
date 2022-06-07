package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/">https://leetcode.cn/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/</a>
 */
public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        Solution solution = new AsFarFromLandAsPossible().new Solution();

        int[][] grid = {
                {1, 0, 1}, {0, 0, 0}, {1, 0, 1}
        };
        System.out.println(solution.maxDistance(grid));

        grid = new int[][]{
                {1, 0, 0}, {0, 0, 0}, {0, 0, 0}
        };
        System.out.println(solution.maxDistance(grid));

        grid = new int[][]{
                {0, 0, 0}, {0, 0, 0}, {0, 0, 0}
        };
        System.out.println(solution.maxDistance(grid));

        grid = new int[][]{
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        };
        System.out.println(solution.maxDistance(grid));
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

        public int maxDistance(int[][] grid) {
            width = grid[0].length;
            height = grid.length;

            Queue<int[]> queue = new ArrayDeque<>();

            // 将所有陆地加入队列
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (grid[r][c] == 1) {
                        queue.offer(new int[]{r, c});
                    }
                }
            }

            // 判断是否全部是陆地或者海洋
            if (queue.size() == 0 || queue.size() == width * height) {
                return -1;
            }

            // 从每块陆地出发，BFS 扫描海洋
            int[] point = null;
            while (!queue.isEmpty()) {
                point = queue.poll();

                // 扫描四个方向
                for (int[] dir : dirs) {
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];

                    if (r < 0 || r >= height || c < 0 || c >= width || grid[r][c] != 0) {
                        continue;
                    }

                    grid[r][c] = grid[point[0]][point[1]] + 1;
                    queue.offer(new int[] {r, c});
                }
            }

            // 最后一次扫描过的坐标点，就是最远的海洋
            return grid[point[0]][point[1]] - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
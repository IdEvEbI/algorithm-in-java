package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. 迷宫中离入口最近的出口
 */
public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        Solution solution = new NearestExitFromEntranceInMaze().new Solution();

        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        System.out.println(solution.nearestExit(maze, new int[]{1, 2}));

        maze = new char[][]{
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        System.out.println(solution.nearestExit(maze, new int[]{1, 0}));

        maze = new char[][]{
                {'.', '+'}
        };
        System.out.println(solution.nearestExit(maze, new int[]{0, 0}));

        maze = new char[][]{
                {'.'}
        };
        System.out.println(solution.nearestExit(maze, new int[]{0, 0}));
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

        public int nearestExit(char[][] maze, int[] entrance) {
            width = maze[0].length;
            height = maze.length;
            Queue<int[]> queue = new LinkedList<>();
            // 将入口加入队列，并修改为墙（r, c, step)
            queue.offer(new int[]{entrance[0], entrance[1], 0});
            maze[entrance[0]][entrance[1]] = '+';

            // BFS
            while (!queue.isEmpty()) {
                int[] data = queue.poll();

                for (int[] dir : dirs) {
                    int r = data[0] + dir[0];
                    int c = data[1] + dir[1];
                    int step = data[2];

                    if (r < 0 || r >= height || c < 0 || c >= width) {
                        if (step != 0) {
                            return step;
                        }
                        continue;
                    }
                    if (maze[r][c] == '.') {
                        // 修改地图标记
                        maze[r][c] = '+';
                        queue.offer(new int[]{r, c, step + 1});
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
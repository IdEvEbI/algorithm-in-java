package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 参考题解：<a href="https://leetcode.cn/problems/flood-fill/solution/python3-dfs-yu-bfs-liang-chong-fang-fa-san-chong-s/">https://leetcode.cn/problems/flood-fill/solution/python3-dfs-yu-bfs-liang-chong-fang-fa-san-chong-s/</a>
 */
public class Leetcode733FloodFill {
    public static void main(String[] args) {
        Solution solution = new Leetcode733FloodFill().new Solution();

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = solution.floodFill(image, 1, 1, 2);

        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：DFS 深度优先搜索（递归）
         */
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            // 初始颜色
            int originalColor = image[sr][sc];

            return floodFillDFS(image, sr, sc, newColor, originalColor);
        }

        /**
         * 在使用 DFS 递归调用时，需要判断一下 newColor，否则在提交代码是，测试用例会出现堆栈溢出
         */
        private int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor, int originalColor) {
            // 图像宽高
            int width = image[0].length;
            int height = image.length;

            if (sr >= 0 && sr < height && sc >= 0 && sc < width && image[sr][sc] == originalColor && image[sr][sc] != newColor) {
                image[sr][sc] = newColor;

                floodFillDFS(image, sr, sc - 1, newColor, originalColor);
                floodFillDFS(image, sr + 1, sc, newColor, originalColor);
                floodFillDFS(image, sr, sc + 1, newColor, originalColor);
                floodFillDFS(image, sr - 1, sc, newColor, originalColor);
            }

            return image;
        }

        /**
         * 方法 2：DFS 深度优先搜索
         * <p>
         * 1. DFS 通常和 栈 搭配使用
         * 2. DFS 的代码除了数据结构不同，算法实现完全一样
         */
        public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
            // 0. 如果新颜色和当前色相同，直接返回
            if (newColor == image[sr][sc]) {
                return image;
            }

            // 1. 准备工作
            // 定义四个方向：上、右、下、左
            int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
            // 定义栈
            Stack<int[]> stack = new Stack<>();

            // 起始点入栈
            stack.push(new int[]{sr, sc});
            // 初始颜色
            int originalColor = image[sr][sc];
            // 图像宽高
            int width = image[0].length;
            int height = image.length;

            // 2. 用 DFS 渲染图像
            while (!stack.isEmpty()) {
                // 2.1 出栈点坐标，并渲染新颜色
                int[] point = stack.pop();
                image[point[0]][point[1]] = newColor;

                // 2.2 遍历四个方向
                for (int[] dir : dirs) {
                    // 计算新的坐标点坐标
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];

                    // 判断新坐标的位置在边界内，同时颜色是初始颜色
                    if (r >= 0 && r < height && c >= 0 && c < width && image[r][c] == originalColor) {
                        // 新坐标入队
                        stack.push(new int[]{r, c});
                    }
                }
            }

            return image;
        }

        /**
         * 方法 3：BFS 广度优先搜索
         * <p>
         * 1. BFS 通常和 队列 搭配使用
         * 2. 从 image[sr][sc] 开始找周围的 4 个点（把最近一圈搞定）
         * 3. 再处理周围 4 个点对应的周围的点，依次类推……
         */
        public int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {
            // 0. 如果新颜色和当前色相同，直接返回
            if (newColor == image[sr][sc]) {
                return image;
            }

            // 1. 准备工作
            // 定义四个方向：上、右、下、左
            int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

            // 定义队列用于存放当前层需要处理的点
            Queue<int[]> queue = new LinkedList<>();

            // 起始点入队
            queue.offer(new int[]{sr, sc});
            // 初始颜色
            int originalColor = image[sr][sc];
            // 图像宽高
            int width = image[0].length;
            int height = image.length;

            // 2. 扫描队列，用 BFS 渲染图像
            while (!queue.isEmpty()) {
                // 2.1 出队点坐标，并渲染新颜色
                int[] point = queue.poll();
                image[point[0]][point[1]] = newColor;

                // 2.2 遍历四个方向
                for (int[] dir : dirs) {
                    // 计算新的坐标点坐标
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];

                    // 判断新坐标的位置在边界内，同时颜色是初始颜色
                    if (r >= 0 && r < height && c >= 0 && c < width && image[r][c] == originalColor) {
                        // 新坐标入队
                        queue.offer(new int[]{r, c});
                    }
                }
            }

            // 3. 返回渲染完成的图像
            return image;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
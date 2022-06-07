package com.idevebi.datastructures.matrix.leetcode.editor.cn;

/**
 * 1351. 统计有序矩阵中的负数
 */
public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();

        int[][] grid = {{4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}};
        System.out.println(solution.countNegatives(grid));

        grid = new int[][]{{5, 1, 0}, {-5, -5, -5}};
        System.out.println(solution.countNegatives(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            return countWithBinarySearch(grid);
        }

        /**
         * 方法 2：二分查找
         * <p>
         * 题目规则：矩阵中的 行、列 都以非递增顺序排列
         */
        private int countWithBinarySearch(int[][] grid) {
            int count = 0;
            int width = grid[0].length;

            for (int[] row : grid) {
                int l = 0;
                int r = width - 1;
                int pos = -1;

                // 在行中用二分查找出现负数的位置
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    // 中间左侧有负数
                    if (row[mid] < 0) {
                        pos = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

                // 发现负数
                if (pos != -1) {
                    count += width - pos;
                }
            }

            return count;
        }

        /**
         * 方法 1：暴力解法
         */
        private int bruteForce(int[][] grid) {
            int count = 0;

            for (int[] row : grid) {
                for (int n : row) {
                    if (n < 0) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
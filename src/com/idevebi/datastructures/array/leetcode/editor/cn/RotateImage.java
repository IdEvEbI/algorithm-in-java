package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 48. 旋转图像
 */
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            rotateTwice(matrix);
        }

        /**
         * 方法 3：顺时针旋转 = 水平上下翻转 + 主对角线翻转
         */
        private void rotateTwice(int[][] matrix) {
            int n = matrix.length;

            // 1. 水平上下翻转
            for (int r = 0; r < n / 2; r++) {
                for (int c = 0; c < n; c++) {
                    int tmp = matrix[r][c];
                    matrix[r][c] = matrix[n - 1 - r][c];
                    matrix[n - 1 - r][c] = tmp;
                }
            }

            // 2. 主对角线翻转
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < r; c++) {
                    int tmp = matrix[r][c];
                    matrix[r][c] = matrix[c][r];
                    matrix[c][r] = tmp;
                }
            }
        }

        /**
         * 方法 2：原地旋转
         */
        private void rotateInPlace(int[][] matrix) {
            int n = matrix.length;

            // 遍历 1/4 矩阵
            for (int r = 0; r < n / 2; r++) {
                for (int c = r; c < n - 1 - r; c++) {
                    int tmp = matrix[r][c];
                    matrix[r][c] = matrix[n - 1 - c][r];
                    matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
                    matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
                    matrix[c][n - 1 - r] = tmp;
                }
            }
        }

        /**
         * 方法 1：暴力解法，新建一个矩阵，旋转赋值
         * <p>
         * n-1, 0 → 0, 0
         * 0, 0 → 0, n-1
         * 0, n-1 → n-1, n-1
         * n-1, n-1 → n-1, 0
         */
        private void bruteForce(int[][] matrix) {
            int n = matrix.length;
            // 新建一个矩阵
            int[][] ans = new int[n][n];

            // 遍历完整矩阵（可优化）
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    ans[r][c] = matrix[n - 1 - c][r];
                    ans[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
                    ans[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
                    ans[c][n - 1 - r] = matrix[r][c];
                }
            }

            // 将 ans 复制回 matrix
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = ans[r][c];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            setZeroesWithBooleanArray(matrix);
        }

        /**
         * 方法 2：使用 boolean 数组 标记
         */
        private void setZeroesWithBooleanArray(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            boolean[] rows = new boolean[m];
            boolean[] cols = new boolean[n];

            // 1. 遍历数组，记录坐标为 0 的所有行和列
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (matrix[r][c] == 0) {
                        rows[r] = true;
                        cols[c] = true;
                    }
                }
            }

            // 2. 再次遍历数组，根据标记清零
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (rows[r] || cols[c]) {
                        matrix[r][c] = 0;
                    }
                }
            }
        }

        /**
         * 方法 1：使用 HashSet 标记
         */
        private void setZeroesWithHashSet(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();

            // 1. 遍历数组，提取坐标为 0 的所有行和列
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (matrix[r][c] == 0) {
                        rows.add(r);
                        cols.add(c);
                    }
                }
            }

            // 2. 遍历集合
            for (int r : rows) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = 0;
                }
            }
            for (int c : cols) {
                for (int r = 0; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
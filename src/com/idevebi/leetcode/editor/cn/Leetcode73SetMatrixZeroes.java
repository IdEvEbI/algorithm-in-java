package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new Leetcode73SetMatrixZeroes().new Solution();

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：暴力解法，用数组标记行列
         */
        public void setZeroes(int[][] matrix) {
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
         * 方法 2：暴力解法，用集合标记行列
         */
        public void setZeroes2(int[][] matrix) {
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
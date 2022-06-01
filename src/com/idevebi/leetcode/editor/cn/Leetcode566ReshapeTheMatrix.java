package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode566ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution solution = new Leetcode566ReshapeTheMatrix().new Solution();

        int r = 4;
        int c = 2;
        int[][] ans = solution.matrixReshape(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}, r, c);

        for (int i = 0; i < r; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;

            // 判断空间是否足够
            if (m * n != r * c) {
                return mat;
            }

            // 结果数组
            int[][] ans = new int[r][c];

            for (int i = 0; i < m * n; i++) {
                // c 和 n 是列： 行 = 计数 / 列 | 列 = 计数 % 列 是二维数组计算的常用方法
                ans[i / c][i % c] = mat[i / n][i % n];
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
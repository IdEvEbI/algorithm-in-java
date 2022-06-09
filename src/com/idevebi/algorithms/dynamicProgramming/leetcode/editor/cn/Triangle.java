package com.idevebi.algorithms.dynamicProgramming.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();

        int[][] arr = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(solution.minimumTotal(triangleList(arr)));

        System.out.println(solution.minimumTotal(triangleList(new int[][]{{-10}})));
    }

    private static List<List<Integer>> triangleList(int[][] arr) {
        List<List<Integer>> list = new ArrayList();

        for (int[] item : arr) {
            List<Integer> l = new ArrayList<>();

            for (int i : item) {
                l.add(i);
            }

            list.add(l);
        }

        return list;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] f = new int[n][n];

            f[0][0] = triangle.get(0).get(0);

            for (int i = 1; i < n; ++i) {
                f[i][0] = f[i - 1][0] + triangle.get(i).get(0);

                for (int j = 1; j < i; ++j) {
                    f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j])
                            + triangle.get(i).get(j);
                }

                f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
            }

            int total = f[n - 1][0];

            for (int i = 1; i < n; ++i) {
                total = Math.min(total, f[n - 1][i]);
            }

            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
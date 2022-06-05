package com.idevebi.skills.leetcode.editor.cn;

/**
 * 1232. 缀点成线
 */
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAStraightLine().new Solution();

        int[][] coors = {{0, 1}, {1, 3}, {-4, -7}, {5, 11}};
        System.out.println(solution.checkStraightLine(coors));

        coors = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(solution.checkStraightLine(coors));

        coors = new int[][]{{0, 0}, {0, 1}, {0, -1}};
        System.out.println(solution.checkStraightLine(coors));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 提示：两个点在一条直线，就是判断相邻的两个点的斜率一致
         * 注意：如果用等差数列就掉坑了~~~
         */
        public boolean checkStraightLine(int[][] coordinates) {
            // 与原点的差值
            int dX1 = coordinates[1][0] - coordinates[0][0];
            int dY1 = coordinates[1][1] - coordinates[0][1];
            int len = coordinates.length;

            for (int i = 2; i < len; i++) {
                // 与原点的差值
                int dX2 = coordinates[i][0] - coordinates[0][0];
                int dY2 = coordinates[i][1] - coordinates[0][1];

                // 判断斜率是否相等( x1 / y1 == x2 / y2，用乘法防止除零错误）
                if (dX1 * dY2 != dX2 * dY1) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
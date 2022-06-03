package com.idevebi.skills.leetcode.editor.cn;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public static void main(String[] args) {
        Solution solution = new FindNearestPointThatHasTheSameXOrYCoordinate().new Solution();

        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(solution.nearestValidPoint(3, 4, points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0 * d = 0
         * 0 + d = d
         */
        public int nearestValidPoint(int x, int y, int[][] points) {
            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < points.length; i++) {
                // 有效点
                if (x == points[i][0] || y == points[i][1]) {
                    int dis = Math.abs((x - points[i][0]) + (y - points[i][1]));
                    if (dis < min) {
                        min = dis;
                        idx = i;
                    }
                }
            }

            return idx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
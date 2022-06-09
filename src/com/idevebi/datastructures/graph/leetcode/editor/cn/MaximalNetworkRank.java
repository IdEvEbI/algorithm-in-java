package com.idevebi.datastructures.graph.leetcode.editor.cn;

/**
 * 1615. 最大网络秩
 * <p>
 * 参考资料：<a href="https://www.youtube.com/watch?v=lXiv1sw58d0">https://www.youtube.com/watch?v=lXiv1sw58d0</a>
 */
public class MaximalNetworkRank {
    public static void main(String[] args) {
        Solution solution = new MaximalNetworkRank().new Solution();

        int[][] roads = {
                {0, 1}, {0, 3}, {1, 2}, {1, 3}
        };
        System.out.println(solution.maximalNetworkRank(4, roads));

        roads = new int[][]{
                {0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}
        };
        System.out.println(solution.maximalNetworkRank(5, roads));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            // 节点度数
            int[] count = new int[n];
            // 两个城市的连接状态
            int[][] connected = new int[n][n];

            for (int[] road : roads) {
                count[road[0]]++;
                count[road[1]]++;
                connected[road[0]][road[1]] = 1;
                connected[road[1]][road[0]] = 1;
            }

            int rank = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    rank = Math.max(rank, count[i] + count[j] - connected[i][j]);
                }
            }

            return rank;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
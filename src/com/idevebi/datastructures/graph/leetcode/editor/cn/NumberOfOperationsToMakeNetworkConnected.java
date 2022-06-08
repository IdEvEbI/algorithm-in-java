package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 1319. 连通网络的操作次数
 */
public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        Solution solution = new NumberOfOperationsToMakeNetworkConnected().new Solution();

        int[][] connections = {
                {0, 1}, {0, 2}, {1, 2}
        };
        System.out.println(solution.makeConnected(4, connections));

        connections = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
        };
        System.out.println(solution.makeConnected(6, connections));

        connections = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}
        };
        System.out.println(solution.makeConnected(6, connections));

        connections = new int[][]{
                {0, 1}, {0, 2}, {3, 4}, {2, 3}
        };
        System.out.println(solution.makeConnected(5, connections));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<Integer>[] edges;
        private boolean[] used;

        public int makeConnected(int n, int[][] connections) {
            // 线缆数量（数组长度）小于电脑数量（n - 1）
            if (connections.length < n - 1) {
                return -1;
            }

            // 建立边数组（图）
            edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int[] conn : connections) {
                edges[conn[0]].add(conn[1]);
                edges[conn[1]].add(conn[0]);
            }
            // System.out.println(Arrays.toString(edges));

            // 使用标记数组
            used = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    dfs(i);
                    ans++;
                }
            }

            return ans - 1;
        }

        private void dfs(int computer) {
            used[computer] = true;
            for (int v : edges[computer]) {
                if (!used[v]) {
                    dfs(v);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
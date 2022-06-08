package com.idevebi.datastructures.graph.leetcode.editor.cn;

/**
 * 547. 省份数量
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected));

        isConnected = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int cities = isConnected.length;
            // 是否访问标记，防止重复搜索
            boolean[] visited = new boolean[cities];
            int provinces = 0;

            for (int i = 0; i < cities; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, cities, i);
                    provinces++;
                }
            }

            return provinces;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
            for (int j = 0; j < cities; j++) {
                if (isConnected[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, visited, cities, j);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
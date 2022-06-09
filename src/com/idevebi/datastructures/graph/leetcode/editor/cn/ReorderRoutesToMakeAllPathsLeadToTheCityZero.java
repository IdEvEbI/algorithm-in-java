package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 1466. 重新规划路线
 * <p>
 * 参考资料：<a href="https://www.youtube.com/watch?v=tnxrs_NelQ4">https://www.youtube.com/watch?v=tnxrs_NelQ4</a>
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        Solution solution = new ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();

        int[][] connections = {
                {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}
        };
        System.out.println(solution.minReorder(6, connections));

        connections = new int[][]{
                {1, 0}, {1, 2}, {3, 2}, {3, 4}
        };
        System.out.println(solution.minReorder(5, connections));

        connections = new int[][]{
                {1, 0}, {2, 0}
        };
        System.out.println(solution.minReorder(3, connections));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minReorder(int n, int[][] connections) {

            List<List<Integer>> el = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                el.add(new ArrayList<>());
            }
            for (int[] c : connections) {
                el.get(c[0]).add(c[1]);
                el.get(c[1]).add(-c[0]);
            }

            return dfs(el, new boolean[n], 0);
        }

        private int dfs(List<List<Integer>> el, boolean[] visited, int root) {
            int cnt = 0;
            visited[root] = true;

            for (int to : el.get(root)) {
                if (!visited[Math.abs(to)]) {
                    cnt += dfs(el, visited, Math.abs(to)) + ((to > 0) ? 1 : 0);
                }
            }

            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
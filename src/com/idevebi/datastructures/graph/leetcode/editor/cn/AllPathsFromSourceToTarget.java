package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 797. 所有可能的路径
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();

        int[][] graph = {
                {1, 2}, {3}, {3}, {}
        };
        System.out.println(solution.allPathsSourceTarget(graph));

        graph = new int[][]{
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
        };
        System.out.println(solution.allPathsSourceTarget(graph));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans;
        private Deque<Integer> path;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            ans = new ArrayList<>();
            path = new ArrayDeque<>();

            path.offerLast(0);
            dfs(graph, 0);

            return ans;
        }

        private void dfs(int[][] graph, int x) {
            if (x == graph.length - 1) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int y : graph[x]) {
                path.offerLast(y);
                dfs(graph, y);
                path.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
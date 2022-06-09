package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 886. 可能的二分法
 */
public class PossibleBipartition {
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition().new Solution();

        int[][] dislikes = {
                {1, 2}, {1, 3}, {2, 4}
        };
        System.out.println(solution.possibleBipartition(4, dislikes));

        dislikes = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}
        };
        System.out.println(solution.possibleBipartition(5, dislikes));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 邻接表
         */
        private ArrayList[] graph;
        /**
         * 记录上色结果
         */
        private Map<Object, Integer> color;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 使用 1~n
            graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            // 图初始化
            for (int[] cp : dislikes) {
                graph[cp[0]].add(cp[1]);
                graph[cp[1]].add(cp[0]);
            }

            color = new HashMap();
            for (int node = 1; node < n + 1; node++) {
                // 判断是否上色
                if (!color.containsKey(node) && !dfs(node, 0)) {
                    return false;
                }
            }

            return true;
        }

        private boolean dfs(int node, int c) {
            // 如果已经上色，检查颜色是否正确
            if (color.containsKey(node)) {
                return color.get(node) == c;
            }

            // 上色
            color.put(node, c);

            for (Object nei : graph[node]) {
                if (!dfs((int) nei, c ^ 1)) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
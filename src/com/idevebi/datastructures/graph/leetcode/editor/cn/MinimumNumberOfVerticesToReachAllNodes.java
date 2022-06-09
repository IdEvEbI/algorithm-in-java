package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1557. 可以到达所有点的最少点数目
 */
public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfVerticesToReachAllNodes().new Solution();

        int[][] edges = {
                {0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}
        };
        System.out.println(solution.findSmallestSetOfVertices(6, edgeList(edges)));

        edges = new int[][]{
                {0, 1}, {2, 1}, {3, 1}, {1, 4}, {2, 4}
        };
        System.out.println(solution.findSmallestSetOfVertices(6, edgeList(edges)));
    }

    private static List<List<Integer>> edgeList(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int[] ed : edges) {
            List<Integer> l = new ArrayList<>();
            l.add(ed[0]);
            l.add(ed[1]);

            list.add(l);
        }

        return list;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            return findWithArraySet(n, edges);
        }

        /**
         * 方法 2：使用数组保存入度
         */
        private List<Integer> findWithArraySet(int n, List<List<Integer>> edges) {
            int len = edges.size();
            int[] inDegrees = new int[n];

            // 填充入度数组
            for (List<Integer> edge : edges) {
                inDegrees[edge.get(1)]++;
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 0) {
                    ans.add(i);
                }
            }

            return ans;
        }

        /**
         * 方法 1：使用 HashSet 作为入度集合
         */
        private List<Integer> findWithHasSet(int n, List<List<Integer>> edges) {
            List<Integer> ans = new ArrayList<>();
            // 入度集合
            Set<Integer> inDegreesSet = new HashSet<>();

            // 填充入度集合
            for (List<Integer> edge : edges) {
                inDegreesSet.add(edge.get(1));
            }

            // 扫描入度集合
            for (int i = 0; i < n; i++) {
                if (!inDegreesSet.contains(i)) {
                    ans.add(i);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
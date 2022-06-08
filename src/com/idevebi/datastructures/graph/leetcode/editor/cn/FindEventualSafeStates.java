package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 802. 找到最终的安全状态
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/find-eventual-safe-states/solution/gtalgorithm-san-ju-hua-jiao-ni-wan-zhuan-xf5o/">https://leetcode.cn/problems/find-eventual-safe-states/solution/gtalgorithm-san-ju-hua-jiao-ni-wan-zhuan-xf5o/</a>
 */
public class FindEventualSafeStates {
    public static void main(String[] args) {
        Solution solution = new FindEventualSafeStates().new Solution();

        int[][] graph = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        System.out.println(solution.eventualSafeNodes(graph));

        graph = new int[][]{
                {1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}
        };
        System.out.println(solution.eventualSafeNodes(graph));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            // 反图
            List<List<Integer>> newGraph = new ArrayList<>();
            // 节点入度
            int[] InDeg = new int[n];

            for (int i = 0; i < n; i++) {
                newGraph.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    newGraph.get(graph[i][j]).add(i);
                }
                // 记录反图中的节点入度
                InDeg[i] = graph[i].length;
            }
            // System.out.println(newGraph);

            // 拓扑排序
            Queue<Integer> queue = new LinkedList<>();

            // 将入度为 0 的点存入队列
            for (int i = 0; i < n; i++) {
                if (InDeg[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int x : newGraph.get(node)) {
                    InDeg[x]--;
                    if (InDeg[x] == 0) {
                        queue.offer(x);
                    }
                }
            }

            // 最终入度为 0 的所有点是安全节点
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (InDeg[i] == 0) {
                    ans.add(i);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
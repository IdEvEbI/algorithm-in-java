package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 847. 访问所有节点的最短路径
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/shortest-path-visiting-all-nodes/solution/gtalgorithm-tu-jie-fa-ba-hardbian-cheng-v5knb/">https://leetcode.cn/problems/shortest-path-visiting-all-nodes/solution/gtalgorithm-tu-jie-fa-ba-hardbian-cheng-v5knb/</a>
 * 参考资料：<a href="https://leetcode.cn/problems/shortest-path-visiting-all-nodes/solution/tong-ge-lai-shua-ti-la-bfs-si-lu-zhuan-h-jl3s/">https://leetcode.cn/problems/shortest-path-visiting-all-nodes/solution/tong-ge-lai-shua-ti-la-bfs-si-lu-zhuan-h-jl3s/</a>
 */
public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        Solution solution = new ShortestPathVisitingAllNodes().new Solution();

        int[][] graph = {
                {1, 2, 3}, {0}, {0}, {0}
        };
        System.out.println(solution.shortestPathLength(graph));

        graph = new int[][]{
                {1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}
        };
        System.out.println(solution.shortestPathLength(graph));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathLength(int[][] graph) {
            int n = graph.length;

            boolean[][] visited = new boolean[n][1 << n];
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                queue.offer(new int[]{i, 1 << i});
                visited[i][1 << i] = true;
            }

            // BFS 扫描层数
            int level = 0;

            while (!queue.isEmpty()) {
                level++;

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] data = queue.poll();
                    int curr = data[0];
                    int state = data[1];

                    // 扫描
                    for (int next : graph[curr]) {
                        // 计算路径状态
                        int nextState = state | (1 << next);
                        // 如果已经访问了所有节点，直接返回
                        if (nextState == ((1 << n) - 1)) {
                            return level;
                        }
                        if (!visited[next][nextState]) {
                            queue.offer(new int[]{next, nextState});
                            visited[next][nextState] = true;
                        }
                    }
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
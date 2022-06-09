package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. 判断二分图
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/is-graph-bipartite/solution/bfs-dfs-bing-cha-ji-san-chong-fang-fa-pan-duan-er-/">https://leetcode.cn/problems/is-graph-bipartite/solution/bfs-dfs-bing-cha-ji-san-chong-fang-fa-pan-duan-er-/</a>
 */
public class IsGraphBipartite {
    public static void main(String[] args) {
        Solution solution = new IsGraphBipartite().new Solution();

        int[][] graph = {
                {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
        };
        System.out.println(solution.isBipartite(graph));

        graph = new int[][]{
                {1, 3}, {0, 2}, {1, 3}, {0, 2}
        };
        System.out.println(solution.isBipartite(graph));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 问题转化：找到一个使用两种颜色的着色方案，使每条边连接的两点颜色均不同
         */
        public boolean isBipartite(int[][] graph) {
            int len = graph.length;
            // 使用 1, -1 表示颜色
            int[] visited = new int[len];
            Queue<Integer> queue = new LinkedList<>();

            // 确保能够遍历到所有点
            for (int i = 0; i < len; i++) {
                if (visited[i] != 0) {
                    continue;
                }

                // BFS
                queue.offer(i);
                visited[i] = 1;

                while (!queue.isEmpty()) {
                    int v = queue.poll();

                    for (int w : graph[v]) {
                        // 判断与相邻节点的颜色是否相同
                        if (visited[w] == visited[v]) {
                            return false;
                        }
                        if (visited[w] == 0) {
                            visited[w] = -visited[v];
                            queue.offer(w);
                        }
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
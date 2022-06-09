package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1129. 颜色交替的最短路径
 * <p>
 * 参考资料：<a href="https://www.youtube.com/watch?v=NeloI9ehWag">https://www.youtube.com/watch?v=NeloI9ehWag</a>
 */
public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        Solution solution = new ShortestPathWithAlternatingColors().new Solution();

        int[] ans = solution.shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{});
        System.out.println(Arrays.toString(ans));

        ans = solution.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{2, 1}});
        System.out.println(Arrays.toString(ans));

        ans = solution.shortestAlternatingPaths(3, new int[][]{{1, 0}}, new int[][]{{2, 1}});
        System.out.println(Arrays.toString(ans));

        ans = solution.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{1, 2}});
        System.out.println(Arrays.toString(ans));

        ans = solution.shortestAlternatingPaths(3, new int[][]{{0, 1}, {0, 2}}, new int[][]{{1, 0}});
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] rList, bList;
        int[] rStep, bStep;

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            int inf = 128;

            rList = new ArrayList[n];
            bList = new ArrayList[n];
            rStep = new int[n];
            bStep = new int[n];

            for (int i = 1; i < n; i++) {
                rStep[i] = bStep[i] = inf;
            }
            for (int i = 0; i < n; i++) {
                rList[i] = new ArrayList<Integer>();
                bList[i] = new ArrayList<Integer>();
            }

            for (int[] edge : redEdges) {
                rList[edge[0]].add(edge[1]);
            }
            for (int[] edge : blueEdges) {
                bList[edge[0]].add(edge[1]);
            }

            dfs(0, 0, true);
            dfs(0, 0, false);

            int[] ans = new int[n];
            for (int i = 1; i < n; i++) {
                int step = Math.min(rStep[i], bStep[i]);
                ans[i] = step == inf ? -1 : step;
            }
            return ans;
        }

        void dfs(int x, int step, boolean isRed) {
            if (isRed) {
                for (int i : rList[x]) {
                    if (rStep[i] <= step + 1) {
                        continue;
                    }
                    rStep[i] = step + 1;
                    dfs(i, step + 1, false);
                }
            } else {
                for (int i : bList[x]) {
                    if (bStep[i] <= step + 1) {
                        continue;
                    }
                    bStep[i] = step + 1;
                    dfs(i, step + 1, true);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
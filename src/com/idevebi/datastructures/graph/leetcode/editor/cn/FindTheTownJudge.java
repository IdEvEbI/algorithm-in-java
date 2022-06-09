package com.idevebi.datastructures.graph.leetcode.editor.cn;

/**
 * 997. 找到小镇的法官
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        Solution solution = new FindTheTownJudge().new Solution();

        int[][] trust = {{1, 2}};
        System.out.println(solution.findJudge(2, trust));

        trust = new int[][]{{1, 3}, {2, 3}};
        System.out.println(solution.findJudge(3, trust));

        trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        System.out.println(solution.findJudge(3, trust));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findJudge(int n, int[][] trust) {
            // 入度 & 出度
            int[] inDegrees = new int[n + 1];
            int[] outDegrees = new int[n + 1];

            for (int[] edge : trust) {
                inDegrees[edge[1]]++;
                outDegrees[edge[0]]++;
            }

            for (int i = 1; i <= n; i++) {
                if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
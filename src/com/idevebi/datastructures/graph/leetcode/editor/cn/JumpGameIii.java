package com.idevebi.datastructures.graph.leetcode.editor.cn;

/**
 * 1306. 跳跃游戏 III
 */
public class JumpGameIii {
    public static void main(String[] args) {
        Solution solution = new JumpGameIii().new Solution();

        System.out.println(solution.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(solution.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(solution.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 访问标记，避免重复搜索
        private boolean[] visited;

        public boolean canReach(int[] arr, int start) {
            visited = new boolean[arr.length];

            return dfs(arr, start);
        }

        private boolean dfs(int[] arr, int i) {
            if (i < 0 || i >= arr.length || visited[i]) {
                return false;
            }

            visited[i] = true;

            return arr[i] == 0 || dfs(arr, i + arr[i]) || dfs(arr, i - arr[i]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
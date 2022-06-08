package com.idevebi.datastructures.graph.leetcode.editor.cn;

/**
 * 1376. 通知所有员工所需的时间
 */
public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        Solution solution = new TimeNeededToInformAllEmployees().new Solution();

        // 公司只有一个人
        System.out.println(solution.numOfMinutes(1, 0,
                new int[]{-1}, new int[]{0}));
        // 公司老大是 2 号，管理 5 人，需要 1 分钟通知
        System.out.println(solution.numOfMinutes(6, 2,
                new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            int ans = 0;
            int[] time = new int[n];

            // 遍历所有人
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dfs(manager, time, informTime, i));
            }

            return ans;
        }

        private int dfs(int[] manager, int[] time, int[] informTime, int id) {
            // 老板直接返回
            if (manager[id] == -1) {
                return 0;
            }
            if (time[manager[id]] != 0) {
                return time[id] = time[manager[id]] + informTime[manager[id]];
            }

            time[id] = dfs(manager, time, informTime, manager[id]) + informTime[manager[id]];

            return time[id];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
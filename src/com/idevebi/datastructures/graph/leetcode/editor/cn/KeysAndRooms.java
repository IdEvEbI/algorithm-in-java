package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 841. 钥匙和房间
 */
public class KeysAndRooms {
    public static void main(String[] args) {
        Solution solution = new KeysAndRooms().new Solution();

        int[][] rooms = {{1}, {2}, {3}, {}};
        List<List<Integer>> list = addRoomsToList(rooms);
        System.out.println(solution.canVisitAllRooms(list));

        rooms = new int[][]{{1, 3}, {3, 0, 1}, {2}, {0}};
        list = addRoomsToList(rooms);
        System.out.println(solution.canVisitAllRooms(list));
    }

    private static List<List<Integer>> addRoomsToList(int[][] rooms) {
        List<List<Integer>> res = new ArrayList<>();

        for (int[] room : rooms) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int r : room) {
                list.add(r);
            }

            res.add(list);
        }

        return res;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 访问房间计数
        private int count;
        // 标记节点是否已访问，避免重复遍历
        private boolean[] visited;

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int size = rooms.size();

            count = 0;
            visited = new boolean[size];

            dfs(rooms, 0);

            return size == count;
        }

        private void dfs(List<List<Integer>> rooms, int idx) {
            visited[idx] = true;
            count++;

            // 遍历 idx 编号的房间能够去到哪些房间
            for (int n : rooms.get(idx)) {
                if (!visited[n]) {
                    dfs(rooms, n);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
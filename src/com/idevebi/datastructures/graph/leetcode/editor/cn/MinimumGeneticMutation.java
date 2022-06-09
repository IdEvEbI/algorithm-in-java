package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.*;

/**
 * 433. 最小基因变化
 */
public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();

        String[] bank = {"AACCGGTA"};
        System.out.println(solution.minMutation("AACCGGTT", "AACCGGTA", bank));

        bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", bank));

        bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC", bank));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            // 基础判断
            if (start.equals(end)) {
                return 0;
            }

            Set<String> count = new HashSet<>();
            Set<String> visited = new HashSet<>();

            char[] keys = {'A', 'C', 'G', 'T'};
            Collections.addAll(count, bank);

            // 基因库不包含目标基因直接返回
            if (!count.contains(end)) {
                return -1;
            }

            // BFS
            Queue<String> queue = new LinkedList<>();
            queue.offer(start);
            visited.add(start);
            int step = 0;

            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String curr = queue.poll();

                    // 一条基因序列由 8 个字符组成
                    for (int j = 0; j < 8; j++) {
                        // 每个基因片段只能是 A、C、G、T 四个字符之一
                        for (int k = 0; k < 4; k++) {
                            if (keys[k] != curr.charAt(j)) {
                                char[] chars = curr.toCharArray();
                                chars[j] = keys[k];
                                String next = new String(chars);

                                if (!visited.contains(next) && count.contains(next)) {
                                    if (next.equals(end)) {
                                        return step;
                                    }
                                    queue.offer(next);
                                    visited.add(next);
                                }
                            }
                        }
                    }
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
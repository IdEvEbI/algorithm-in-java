package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.*;

/**
 * 752. 打开转盘锁
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/open-the-lock/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-wyr9/">https://leetcode.cn/problems/open-the-lock/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-wyr9/</a>
 */
public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();

        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution.openLock(deadends, "0202"));

        deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(solution.openLock(deadends, "8888"));

        deadends = new String[]{"8888"};
        System.out.println(solution.openLock(deadends, "0009"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            // 1. 基础判断 + 准备 HashSet
            if ("0000".equals(target)) {
                return 0;
            }

            Set<String> dead = new HashSet<>();
            Collections.addAll(dead, deadends);

            if (dead.contains("0000")) {
                return -1;
            }

            // 2. BFS 准备
            int step = 0;
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            Set<String> visited = new HashSet<>();
            visited.add("0000");

            // 3. BFS
            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String status = queue.poll();

                    for (String nextStatus : get(status)) {
                        if (!visited.contains(nextStatus) && !dead.contains(nextStatus)) {
                            if (nextStatus.equals(target)) {
                                return step;
                            }
                            queue.offer(nextStatus);
                            visited.add(nextStatus);
                        }
                    }
                }
            }

            return -1;
        }

        /**
         * 枚举通过一次旋转能够得到的数字
         */
        private List<String> get(String status) {
            List<String> ret = new ArrayList<>();

            char[] chars = status.toCharArray();
            for (int i = 0; i < 4; i++) {
                char numChar = chars[i];

                chars[i] = numPrev(numChar);
                ret.add(new String(chars));
                chars[i] = numSucc(numChar);
                ret.add(new String(chars));

                chars[i] = numChar;
            }

            return ret;
        }

        private char numSucc(char numChar) {
            return numChar == '9' ? '0' : (char) (numChar + 1);
        }

        private char numPrev(char numChar) {
            return numChar == '0' ? '9' : (char) (numChar - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
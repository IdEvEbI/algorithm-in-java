package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1654. 到家的最少跳跃次数
 * <p>
 * 参考资料：<a href="https://www.youtube.com/watch?v=hn7k3udp2_8">https://www.youtube.com/watch?v=hn7k3udp2_8</a>
 */
public class MinimumJumpsToReachHome {
    public static void main(String[] args) {
        Solution solution = new MinimumJumpsToReachHome().new Solution();

        System.out.println(solution.minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));
        System.out.println(solution.minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
        System.out.println(solution.minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            if (x == 0) {
                return 0;
            }

            int xLen = 6000;

            Deque<Integer> queue = new LinkedList();
            boolean[] vistedR = new boolean[xLen];
            boolean[] vistedL = new boolean[xLen];

            for (int i : forbidden) {
                vistedL[i] = vistedR[i] = true;
            }

            int step = 0;
            vistedR[0] = vistedL[0] = true;
            queue.add(0);

            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int signPos = queue.pop();
                    int pos = Math.abs(signPos);
                    int pre = pos - b, post = pos + a;

                    if (signPos > 0 && pre == x || post == x) {
                        return step;
                    }
                    if (post < xLen && !vistedR[post]) {
                        queue.add(post);
                        vistedR[post] = true;
                    }
                    if (signPos > 0 && pre > 0 && !vistedL[pre]) {
                        queue.add(-pre);
                        vistedL[pre] = true;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.graph.leetcode.editor.cn;

/**
 * 365. 水壶问题
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/water-and-jug-problem/solution/tu-de-yan-du-you-xian-bian-li-by-liweiwei1419/">https://leetcode.cn/problems/water-and-jug-problem/solution/tu-de-yan-du-you-xian-bian-li-by-liweiwei1419/</a>
 */
public class WaterAndJugProblem {
    public static void main(String[] args) {
        Solution solution = new WaterAndJugProblem().new Solution();

        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(2, 6, 5));
        System.out.println(solution.canMeasureWater(1, 2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            if (jug1Capacity + jug2Capacity < targetCapacity) {
                return false;
            }
            if (jug1Capacity == 0 || jug2Capacity == 0) {
                return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
            }

            return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
        }

        private int gcd(int x, int y) {
            int remainder = x % y;

            while (remainder != 0) {
                x = y;
                y = remainder;

                remainder = x % y;
            }
            return y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
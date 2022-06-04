package com.idevebi.skills.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 */
public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();

        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            return isHappyWithFastSlow(n);
        }

        /**
         * 方法 2：使用快慢指针判断是否出现循环
         */
        private boolean isHappyWithFastSlow(int n) {
            int slow = n;
            int fast = nextNum(n);

            while (fast != 1 && slow != fast) {
                slow = nextNum(slow);
                fast = nextNum(nextNum(fast));
            }

            return fast == 1;
        }

        /**
         * 方法 1：使用 HashSet 判断是否出现循环
         */
        private boolean isHappyWithSet(int n) {
            Set<Integer> set = new HashSet<>();

            while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = nextNum(n);
            }

            return n == 1;
        }

        /**
         * 计算每位数字的平方和
         */
        private int nextNum(int n) {
            int sum = 0;

            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                sum += d * d;
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
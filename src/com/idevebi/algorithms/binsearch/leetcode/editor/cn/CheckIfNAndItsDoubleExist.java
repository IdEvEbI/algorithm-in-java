package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 1346. 检查整数及其两倍数是否存在
 */
public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Solution solution = new CheckIfNAndItsDoubleExist().new Solution();

        System.out.println(solution.checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(solution.checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(solution.checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(solution.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
        System.out.println(solution.checkIfExist(new int[]{0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            return checkWithHash(arr);
        }

        /**
         * 方法 2：哈希表
         */
        private boolean checkWithHash(int[] arr) {
            Set<Integer> set = new HashSet<>();

            for (int n : arr) {
                if (set.contains(2 * n) || (n % 2 == 0 && set.contains(n / 2))) {
                    return true;
                }
                set.add(n);
            }

            return false;
        }

        /**
         * 方法 1：暴力解法
         */
        private boolean bruteForce(int[] arr) {
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i != j && arr[i] * 2 == arr[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
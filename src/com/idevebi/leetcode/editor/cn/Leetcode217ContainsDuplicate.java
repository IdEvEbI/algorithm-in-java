package com.idevebi.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Leetcode217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Leetcode217ContainsDuplicate().new Solution();

        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int n : nums) {
                if (!set.add(n)) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
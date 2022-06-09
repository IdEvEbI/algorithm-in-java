package com.idevebi.algorithms.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();

        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            List<Integer> output = new ArrayList<>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);

            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
            }

            for (int i = first; i < n; i++) {
                Collections.swap(output, first, i);
                backtrack(n, output, res, first + 1);
                Collections.swap(output, first, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
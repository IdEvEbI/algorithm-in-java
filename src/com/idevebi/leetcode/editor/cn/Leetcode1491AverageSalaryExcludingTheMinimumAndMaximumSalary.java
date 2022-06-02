package com.idevebi.leetcode.editor.cn;

public class Leetcode1491AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public static void main(String[] args) {
        Solution solution = new Leetcode1491AverageSalaryExcludingTheMinimumAndMaximumSalary().new Solution();

        System.out.println(solution.average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        System.out.println(solution.average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double average(int[] salary) {
            double sum = 0;
            double max = Integer.MIN_VALUE;
            double min = Integer.MAX_VALUE;

            for (int n : salary) {
                sum += n;
                max = Math.max(n, max);
                min = Math.min(n, min);
            }

            // 题目规则保证 salary.length >= 3
            return (sum - max - min) / (salary.length - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
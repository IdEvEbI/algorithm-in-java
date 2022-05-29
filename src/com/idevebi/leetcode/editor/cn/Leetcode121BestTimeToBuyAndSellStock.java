package com.idevebi.leetcode.editor.cn;

public class Leetcode121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new Leetcode121BestTimeToBuyAndSellStock().new Solution();

        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int minPrice = Integer.MAX_VALUE;
            int profit = 0;

            // 遍历数组，向后更新最小价格及最大收益
            for (int n : prices) {
                if (n < minPrice) {
                    minPrice = n;
                } else if (n - minPrice > profit) {
                    profit = n - minPrice;
                }
            }

            return profit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
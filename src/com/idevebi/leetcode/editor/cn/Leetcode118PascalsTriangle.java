package com.idevebi.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Leetcode118PascalsTriangle().new Solution();

        List<List<Integer>> ans = solution.generate(5);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();

            for (int r = 0; r < numRows; r++) {
                List<Integer> row = new ArrayList<>();

                // 生成当前行数组
                for (int c = 0; c <= r; c++) {
                    if (c == 0 || c == r) {
                        row.add(1);
                    } else {
                        // 状态转移方程： ans[r][c] = ans[r - 1][r - 1] + ans[r - 1][c]
                        row.add(ans.get(r - 1).get(c - 1) + ans.get(r - 1).get(c));
                    }
                }

                ans.add(row);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
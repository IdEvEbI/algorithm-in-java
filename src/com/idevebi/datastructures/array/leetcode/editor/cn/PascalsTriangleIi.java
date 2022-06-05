package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();

        System.out.println(solution.getRow(0));
        System.out.println(solution.getRow(1));
        System.out.println(solution.getRow(2));
        System.out.println(solution.getRow(3));
        System.out.println(solution.getRow(4));
        System.out.println(solution.getRow(5));
        System.out.println(solution.getRow(30));
        System.out.println(solution.getRow(33));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int c = 1; c <= rowIndex; c++) {
                // 线性递推公式（数据转换，避免超过 29 数据溢出）
                long d = (long) row.get(c - 1) * (rowIndex - c + 1) / c;
                row.add((int) d);
            }

            return row;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
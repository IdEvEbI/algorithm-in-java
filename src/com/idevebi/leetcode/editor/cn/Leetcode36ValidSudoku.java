package com.idevebi.leetcode.editor.cn;

public class Leetcode36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Leetcode36ValidSudoku().new Solution();

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(board));

        board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：位运算（数独的数字只有一到 9，可以利用二进制的位让数组降维）
         */
        public boolean isValidSudoku(char[][] board) {
            // 定义行、列、小九宫数组（利用二进制的位让数组降维）
            int[] rows = new int[9];
            int[] colums = new int[9];
            int[] boxes = new int[9];

            // 按行扫描
            for (int row = 0; row < 9; row++) {
                // 按列扫描
                for (int col = 0; col < 9; col++) {
                    char c = board[row][col];

                    if (c == '.') {
                        continue;
                    }

                    // 当前行列对应的九宫格位置
                    int k = (row / 3) * 3 + (col / 3);
                    // 位移，数字是几就移动几位，例如 5 → 2 ^ 5 = 32
                    int mask = 1 << (c - '0');

                    // 行、列、九宫格中出现相同数字时，和 mask & 运算的结果不为 0
                    if (((rows[row] | colums[col] | boxes[k]) & mask) != 0) {
                        return false;
                    }

                    rows[row] |= mask;
                    colums[col] |= mask;
                    boxes[k] |= mask;
                }
            }

            return true;
        }

        /**
         * 方法 2：暴力解法
         */
        public boolean isValidSudoku2(char[][] board) {
            // 定义行（二维）、列（二维）、小九宫数组（三维）
            int[][] rows = new int[9][9];
            int[][] colums = new int[9][9];
            int[][][] boxes = new int[3][3][9];

            // 按行扫描
            for (int row = 0; row < 9; row++) {
                // 按列扫描
                for (int col = 0; col < 9; col++) {
                    char c = board[row][col];
                    // 如果不是数字，填充数组
                    if (c != '.') {
                        // Tips: 数组下标从 0 开始，此处需要 - 1
                        int idx = c - '0' - 1;

                        // 更新记录数组
                        rows[row][idx]++;
                        colums[col][idx]++;
                        boxes[row / 3][col / 3][idx]++;

                        // 判断棋盘是否合法：每行、每列、每个九宫中的数字不能 > 1
                        if (rows[row][idx] > 1 ||
                                colums[col][idx] > 1 ||
                                boxes[row / 3][col / 3][idx] > 1) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
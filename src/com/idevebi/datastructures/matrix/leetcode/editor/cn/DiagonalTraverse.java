package com.idevebi.datastructures.matrix.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 498. 对角线遍历
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ans = solution.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(ans));

        mat = new int[][]{{2, 3}};
        ans = solution.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(ans));

        mat = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
        };
        ans = solution.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findDiagonalOrder(int[][] mat) {
            return simulateFind2(mat);
        }

        /**
         * 方法 2：模拟（方法 1 优化）
         */
        private int[] simulateFind2(int[][] mat) {
            int width = mat[0].length;
            int height = mat.length;
            int count = width * height;

            int[] ans = new int[count];

            // 是否向左扫描（左下 → 右上） / 向右扫描（右上 → 左下）
            boolean toLeft = true;

            for (int r = 0, c = 0, idx = 0; idx < count; ) {
                if (toLeft) {
                    // 到达边界跳出
                    while (r >= 0 && c < width) {
                        ans[idx++] = mat[r--][c++];
                    }
                    // 调整行
                    r++;
                    if (c == width) {
                        c--;
                        r++;
                    }
                } else {
                    while (r < height && c >= 0) {
                        ans[idx++] = mat[r++][c--];
                    }
                    // 调整列
                    c++;
                    if (r == height) {
                        r--;
                        c++;
                    }
                }
                toLeft = !toLeft;
            }

            return ans;
        }

        /**
         * 方法 1：模拟法
         * <p>
         * 1. 先从 左下 → 右上 扫描
         * 2. 把坐标位置首先填入数组
         * 3. 根据方向计算新的坐标，如果越界，根据方向重新计算坐标
         */
        private int[] simulateFind(int[][] mat) {
            int width = mat[0].length;
            int height = mat.length;

            int[] ans = new int[width * height];
            // 是否向左扫描（左下 → 右上） / 向右扫描（右上 → 左下）
            boolean toLeft = true;

            for (int r = 0, c = 0, idx = 0; r < height && c < width; ) {
                ans[idx++] = mat[r][c];

                // 计算下一个行和列坐标
                int nextRow = r + (toLeft ? -1 : 1);
                int nextCol = c + (toLeft ? 1 : -1);

                // 判断下一行、列是否越界，如果越界重新调整扫描开始位置
                if (nextRow < 0 || nextRow == height || nextCol < 0 || nextCol == width) {
                    if (toLeft) {
                        r += (c == width - 1 ? 1 : 0);
                        c += (c < width - 1 ? 1 : 0);
                    } else {
                        c += (r == height - 1 ? 1 : 0);
                        r += (r < height - 1 ? 1 : 0);
                    }
                    // 翻转方向
                    toLeft = !toLeft;
                } else {
                    r = nextRow;
                    c = nextCol;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
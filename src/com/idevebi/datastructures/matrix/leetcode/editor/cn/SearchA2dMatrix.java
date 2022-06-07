package com.idevebi.datastructures.matrix.leetcode.editor.cn;

/**
 * 74. 搜索二维矩阵
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(matrix, 3));

        matrix = new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        System.out.println(solution.searchMatrix(matrix, 1));
        System.out.println(solution.searchMatrix(matrix, 7));
        System.out.println(solution.searchMatrix(matrix, 10));
        System.out.println(solution.searchMatrix(matrix, 20));
        System.out.println(solution.searchMatrix(matrix, 23));
        System.out.println(solution.searchMatrix(matrix, 60));
        System.out.println(solution.searchMatrix(matrix, 15));
        System.out.println(solution.searchMatrix(matrix, 100));

        matrix = new int[][]{
                {1}
        };
        System.out.println(solution.searchMatrix(matrix, 1));
        System.out.println(solution.searchMatrix(matrix, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 一次二分查找，把矩阵逐行连接是一个升序一维数组
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int width = matrix[0].length;
            int height = matrix.length;

            int left = 0, right = width * height - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int x = matrix[mid / width][mid % width];

                if (x == target) {
                    return true;
                } else if (x < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
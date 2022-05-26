package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;

public class Leetcode700SearchInABinarySearchTree {
    public static void main(String[] args) {

        /*
         *                5
         *             3     7
         *           1   4  6  9
         */
        // 创建二叉树
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution solution = new Leetcode700SearchInABinarySearchTree().new Solution();

        System.out.println(solution.searchBST(root, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {

            while (root != null) {
                if (root.val == val) {
                    return root;
                }

                root = (root.val > val) ? root.left : root.right;
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
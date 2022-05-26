package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;

public class Leetcode235LowestCommonAncestorOfABinarySearchTree {
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

        Solution solution = new Leetcode235LowestCommonAncestorOfABinarySearchTree().new Solution();

        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.right.left, root.right.right).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 使用遍历实现
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode parent = root;

            while (true) {
                if (p.val < parent.val && q.val < parent.val) {
                    parent = parent.left;
                } else if (p.val > parent.val && q.val > parent.val) {
                    parent = parent.right;
                } else {
                    break;
                }
            }

            return parent;
        }

        /**
         * 使用递归实现
         */
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            // 左子树递归
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor1(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                // 右子树递归
                return lowestCommonAncestor1(root.right, p, q);
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
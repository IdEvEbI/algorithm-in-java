package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.right.left, root.right.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left.left, root.right.right).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p, q);
        }

        /**
         * 方法 1：递归解法，比官方的解法要好理解
         */
        private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            // 在左右子树分别找 p & q
            TreeNode left = dfs(root.left, p, q);
            TreeNode right = dfs(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }

            return left != null ? left : right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
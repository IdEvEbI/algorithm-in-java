package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

/**
 * 110. 平衡二叉树
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();

        System.out.println(solution.isBalanced(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return balanceFromBottom2Top(root);
        }

        /**
         * 方法 2：自底向上
         */
        private boolean balanceFromBottom2Top(TreeNode root) {
            if (root == null) {
                return true;
            }

            return maxDepth(root) != -1;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }

            return Integer.max(left, right) + 1;
        }

        /**
         * 方法 1：自顶向下
         */
        private boolean balanceFromTop2Bottom(TreeNode root) {
            if (root == null) {
                return true;
            }

            int diff = Math.abs(height(root.left) - height(root.right));

            return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode root) {
            return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
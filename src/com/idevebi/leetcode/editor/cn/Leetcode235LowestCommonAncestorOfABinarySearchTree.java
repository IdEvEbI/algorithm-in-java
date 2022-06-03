package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

public class Leetcode235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

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
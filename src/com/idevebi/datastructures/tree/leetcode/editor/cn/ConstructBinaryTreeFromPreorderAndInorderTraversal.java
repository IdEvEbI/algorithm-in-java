package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private int preorderIndex;
        private int inorderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            inorderIndex = 0;

            return buildTreeWithRecursion(preorder, inorder, null);
        }

        /**
         * 方法 2：递归建树
         */
        private TreeNode buildTreeWithRecursion(int[] preorder, int[] inorder, TreeNode end) {
            // 已经扫描完 前序 数组，直接返回
            if (preorderIndex > preorder.length - 1) {
                return null;
            }

            // 使用 preorderIndex 构建根节点
            TreeNode root = new TreeNode(preorder[preorderIndex++]);

            // 构建左子树
            if (inorder[inorderIndex] != root.val) {
                root.left = buildTreeWithRecursion(preorder, inorder, root);
            }

            // 构建右子树
            inorderIndex++;
            if (end == null || inorder[inorderIndex] != end.val) {
                root.right = buildTreeWithRecursion(preorder, inorder, end);
            }

            return root;
        }

        /**
         * 方法 1：迭代法，从左子树开始，通过压栈、弹栈构建右子树
         * <p>
         * 特点：
         * <p>
         * 1. 在前序遍历序列中，第一个元素为树的根节点，第 2 个节点是左子树的根节点……
         * 2. 在中序遍历序列中，根节点的左边为左子树，根节点的右边为右子树
         */
        private TreeNode buildTreeWithIteration(int[] preorder, int[] inorder) {
            // 1. 取 preorder 第 1 项建立根节点
            int len = preorder.length;
            TreeNode root = new TreeNode(preorder[0]);

            // 2. 准备迭代
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            int idx = 0;

            // 3. 从左向右扫描 preorder
            for (int i = 1; i < len; i++) {
                // 当前根节点
                TreeNode n = stack.peek();

                int v = preorder[i];

                if (n.val != inorder[idx]) {
                    n.left = new TreeNode(v);
                    stack.push(n.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[idx]) {
                        n = stack.pop();
                        idx++;
                    }
                    n.right = new TreeNode(v);
                    stack.push(n.right);
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

        // 左根右
        int[] inorder = {9, 3, 15, 20, 7};
        // 左右根
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private int postorderLen;
        private int inorderLen;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTreeWithRecursion(inorder, postorder);
        }

        /**
         * 方法 2：递归建树
         */
        private TreeNode buildTreeWithRecursion(int[] inorder, int[] postorder) {
            postorderLen = postorder.length - 1;
            inorderLen = inorder.length - 1;

            return build(inorder, postorder, null);
        }

        private TreeNode build(int[] inorder, int[] postorder, TreeNode end) {
            if (postorderLen < 0) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[postorderLen--]);

            // 创建右子树
            if (inorder[inorderLen] != root.val) {
                root.right = build(inorder, postorder, root);
            }

            // 创建左子树
            inorderLen--;
            if (end == null || inorder[inorderLen] != end.val) {
                root.left = build(inorder, postorder, end);
            }

            return root;
        }

        /**
         * 方法 1：迭代法，从右子树开始，通过压栈、弹栈构建左子树
         * <p>
         * 特点：
         * <p>
         * 1. 在后序遍历序列中，最后一个元素为树的根节点，倒数第 2 个节点是右子树的根节点……
         * 2. 在中序遍历序列中，根节点的左边为左子树，根节点的右边为右子树
         */
        private TreeNode buildTreeWithIteration(int[] inorder, int[] postorder) {
            // 1. 取  postorder 最后一项建立根节点
            int len = postorder.length;
            TreeNode root = new TreeNode(postorder[len - 1]);

            // 2. 准备迭代
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            int idx = len - 1;

            // 3. 从右向左扫描 postorder 数组
            for (int i = len - 2; i >= 0; i--) {
                // 当前 根 节点
                TreeNode n = stack.peek();

                int v = postorder[i];

                if (n.val != inorder[idx]) {
                    n.right = new TreeNode(v);
                    stack.push(n.right);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[idx]) {
                        n = stack.pop();
                        idx--;
                    }
                    n.left = new TreeNode(v);
                    stack.push(n.left);
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
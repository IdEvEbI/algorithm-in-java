package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Leetcode106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

        int[] inorder = {15, 9, 10, 3, 20, 5, 7, 8, 4};
        int[] postorder = {15, 10, 9, 5, 4, 8, 7, 20, 3};

        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(root.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private int lenInorder;
        private int lenPostorder;

        /**
         * 递归实现
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            lenInorder = inorder.length - 1;
            lenPostorder = postorder.length - 1;

            return build(inorder, postorder, null);
        }

        private TreeNode build(int[] inorder, int[] postorder, TreeNode end) {
            if (lenPostorder < 0) {
                return null;
            }

            // 创建根节点
            TreeNode root = new TreeNode(postorder[lenPostorder--]);
            if (inorder[lenInorder] != root.val) {
                root.right = build(inorder, postorder, root);
            }

            lenInorder--;
            if (end == null || inorder[lenInorder] != end.val) {
                root.left = build(inorder, postorder, end);
            }

            return root;
        }

        /**
         * 迭代法：从右子树开始，通过压栈、弹栈构建左子树
         * <p>
         * 特点：
         * <p>
         * 1. 在后序遍历序列中，最后一个元素为树的根节点
         * 2. 在中序遍历序列中，根节点的左边为左子树，根节点的右边为右子树
         * <p>
         * 思路：
         * <p>
         * 1. 在后序遍历序列中找到根节点(最后一个元素)
         * 2. 根据根节点在中序遍历序列中找到根节点的位置
         * 3. 根据根节点的位置将中序遍历序列分为左子树和右子树
         * 4. 根据根节点的位置确定左子树和右子树在中序数组和后续数组中的左右边界位置
         * 5. 递归构造左子树和右子树
         * <p>
         * 假设：
         * <p>
         * inorder = [15, 9, 10, 3, 20, 5, 7, 8, 4]
         * postorder = [15, 10, 9, 5, 4, 8, 7, 20, 3]
         */
        public TreeNode buildTree2(int[] inorder, int[] postorder) {
            // 1. 判断后续遍历序列是否有内容
            if (postorder == null || postorder.length == 0) {
                return null;
            }
            // 2. 取后续遍历序列的左右一项建立树根
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);

            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            int idx = inorder.length - 1;

            // 3. 从右子树的根节点开始
            for (int i = postorder.length - 2; i >= 0; i--) {
                int v = postorder[i];

                // 根节点
                TreeNode n = stack.peek();

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
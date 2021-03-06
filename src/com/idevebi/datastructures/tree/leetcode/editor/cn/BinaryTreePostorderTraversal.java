package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        List<Integer> list = solution.postorderTraversal(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            return postorderWithRecursion(root);
        }

        /**
         * 方法 2：使用递归实现后序遍历
         */
        private List<Integer> postorderWithRecursion(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 后序调用
            postorder(root, res);

            return res;
        }

        private void postorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            // 左
            postorder(root.left, res);
            // 右
            postorder(root.right, res);
            // 根
            res.add(root.val);
        }

        /**
         * 方法 1：使用 stack 实现后序遍历
         */
        private List<Integer> postorderWithStack(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 判断根节点
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode prev = null;

            while (!stack.isEmpty() || root != null) {
                // 左
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    // 根
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    // 右
                    stack.push(root);
                    root = root.right;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        List<Integer> list = solution.preorderTraversal(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            return preorderWithRecursion(root);
        }

        /**
         * 方法 2：使用递归实现前序遍历
         */
        private List<Integer> preorderWithRecursion(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 前序调用
            preorder(root, res);

            return res;
        }

        private void preorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            // 根
            res.add(root.val);
            // 左
            preorder(root.left, res);
            // 右
            preorder(root.right, res);
        }

        /**
         * 方法 1：使用 stack 实现前序遍历
         */
        private List<Integer> preorderWithStack(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 判断根节点
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode n = root;

            while (!stack.isEmpty() || n != null) {
                // 根 + 左
                while (n != null) {
                    res.add(n.val);
                    stack.push(n);
                    n = n.left;
                }
                // 右
                n = stack.pop();
                n = n.right;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
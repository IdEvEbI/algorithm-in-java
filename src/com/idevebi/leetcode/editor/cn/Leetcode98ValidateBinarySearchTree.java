package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 题目链接：<a href="https://leetcode.cn/problems/validate-binary-search-tree/">https://leetcode.cn/problems/validate-binary-search-tree/</a>
 */
public class Leetcode98ValidateBinarySearchTree {
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

        Solution solution = new Leetcode98ValidateBinarySearchTree().new Solution();

        boolean ans = solution.isValidBST(root);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用递归验证二叉搜索树
         */
        public boolean isValidBST(TreeNode root) {
            return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean valid(TreeNode root, long minValue, long maxValue) {
            if (root == null) {
                return true;
            }
            if (root.val <= minValue || root.val >= maxValue) {
                return false;
            }
            // 左子树的所有值都小于 root.val && 右子树的所有值都大于 root.val
            return valid(root.left, minValue, root.val) && valid(root.right, root.val, maxValue);
        }

        /**
         * 使用中序遍历验证二叉搜索树
         */
        public boolean isValidBST2(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            long preVal = Long.MIN_VALUE;

            while (!stack.isEmpty() || root != null) {
                // 遍历到最左侧节点
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                // 如果中序遍历过程中，出现比之前的值小的情况，说明不是二叉搜索树
                if (root.val <= preVal) {
                    return false;
                }

                preVal = root.val;
                root = root.right;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
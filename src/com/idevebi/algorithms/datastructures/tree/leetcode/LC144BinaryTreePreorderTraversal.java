package com.idevebi.algorithms.datastructures.tree.leetcode;

import com.idevebi.algorithms.datastructures.tree.create.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">https://leetcode.cn/problems/binary-tree-preorder-traversal/</a>
 */
public class LC144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        // 创建二叉树
        TreeNode root = new TreeNode(5);

        /* 左右节点
         *                5
         *             3     7
         *           1   4  6  9
         */
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }

    /**
     * 二叉树前序遍历：根左右
     */
    private static List<Integer> preorderTraversal(TreeNode root) {
        // 遍历结果
        List<Integer> res = new ArrayList<>();

        // 递归前序调用
        preorder(root, res);

        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
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
}


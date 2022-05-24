package com.idevebi.algorithms.datastructures.tree.traversal;

import com.idevebi.algorithms.datastructures.tree.create.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">https://leetcode.cn/problems/binary-tree-inorder-traversal/</a>
 */
public class LC94BinaryTreeInorderTraversal {
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

        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        // 遍历结果
        List<Integer> res = new ArrayList<>();

        // 递归中序调用
        inorder(root, res);

        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 左
        inorder(root.left, res);
        // 根
        res.add(root.val);
        // 右
        inorder(root.right, res);
    }
}

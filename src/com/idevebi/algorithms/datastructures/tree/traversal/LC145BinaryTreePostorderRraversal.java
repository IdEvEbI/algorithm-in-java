package com.idevebi.algorithms.datastructures.tree.traversal;

import com.idevebi.algorithms.datastructures.tree.create.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">https://leetcode.cn/problems/binary-tree-postorder-traversal/</a>
 */
public class LC145BinaryTreePostorderRraversal {
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

        List<Integer> res = postorderTraversal(root);
        System.out.println(res);
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        // 遍历结果
        List<Integer> res = new ArrayList<>();

        // 递归后序调用
        postorder(root, res);

        return res;
    }

    private static void postorder(TreeNode root, List<Integer> res) {
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
}

package com.idevebi.algorithms.datastructures.tree.leetcode;

import com.idevebi.algorithms.datastructures.tree.create.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历
 *
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">https://leetcode.cn/problems/binary-tree-level-order-traversal/</a>
 */
public class LC102BinaryTreeLevelOrderTraversal {
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

        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        // 遍历结果
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();

                l.add(n.val);
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }

            res.add(l);
        }

        return res;
    }
}

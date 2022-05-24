package com.idevebi.algorithms.datastructures.tree.create;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(5);

        /* 左右节点
         *                5
         *             3     7
         *           1   4  6  9
         */
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(4);

        tree.root.right = new TreeNode(7);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(9);

        System.out.println("创建二叉树 DEMO");
    }
}

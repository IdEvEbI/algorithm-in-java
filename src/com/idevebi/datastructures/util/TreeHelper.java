package com.idevebi.datastructures.util;

import com.idevebi.datastructures.tree.TreeNode;

public class TreeHelper {
    /**
     * 创建测试 BST 树
     * <p>
     * 5
     * 3 7
     * 1  4  6  9
     *
     * @return 根节点
     */
    public static TreeNode createTestTree() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        return root;
    }

    /**
     * 创建测试 镜像 树
     *
     * @return 根节点
     */
    public static TreeNode createMirrorTree() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(1);

        return root;
    }
}

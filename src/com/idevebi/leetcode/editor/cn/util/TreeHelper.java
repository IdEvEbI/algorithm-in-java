package com.idevebi.leetcode.editor.cn.util;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;

public class TreeHelper {
    /**
     * 创建测试树
     * <p>
     * 5
     * 3     7
     * 1   4  6  9
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
}

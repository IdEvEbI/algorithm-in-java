package com.idevebi.leetcode.editor.cn.datastructures.tree;

/**
 * 二叉树节点
 */
public class TreeNode {
    /**
     * 节点值
     */
    public int val;
    /**
     * 左子节点
     */
    public TreeNode left;
    /**
     * 右子节点
     */
    public TreeNode right;

    /**
     * 构造器
     */
    public TreeNode() {
    }

    /**
     * 构造器
     *
     * @param val 节点的值
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 构造器
     *
     * @param val   节点的值
     * @param left  左子节点
     * @param right 右子节点
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

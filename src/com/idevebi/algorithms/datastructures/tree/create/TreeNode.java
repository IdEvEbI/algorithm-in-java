package com.idevebi.algorithms.datastructures.tree.create;

/**
 * 树节点
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
     *
     * @param val 节点的值
     */
    TreeNode(int val) {
        this.val = val;
    }
}

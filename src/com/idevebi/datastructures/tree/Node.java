package com.idevebi.datastructures.tree;

import java.util.List;

/**
 * N 叉树节点
 */
public class Node {

    /**
     * 节点值
     */
    public int val;
    /**
     * 子节点列表
     */
    public List<Node> children;

    /**
     * 构造器
     */
    public Node() {

    }

    /**
     * 构造器
     *
     * @param val 节点的值
     */
    public Node(int val) {
        this.val = val;
    }

    /**
     * 构造器
     *
     * @param val      节点的值
     * @param children 子节点列表
     */
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

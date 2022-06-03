package com.idevebi.datastructures.linkedList;

/**
 * 链表节点
 */
public class ListNode {
    /**
     * 节点值
     */
    public int val;
    /**
     * next 指针
     */
    public ListNode next;

    /**
     * 构造器
     */
    public ListNode() {
    }

    /**
     * 构造器
     *
     * @param val 节点的值
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 构造器
     *
     * @param val  节点的值
     * @param next next 节点
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

package com.idevebi.algorithms.datastructures.stack.create;

import com.idevebi.algorithms.datastructures.linkedList.ListNode;

/**
 * 使用链表实现栈
 */
public class StackLinkedList {
    /**
     * 链表头节点（哨兵节点，不保存数据）
     */
    private final ListNode head;

    /**
     * 构造器
     */
    StackLinkedList() {
        this.head = new ListNode(0);
    }

    /**
     * 入栈操作
     *
     * @param val 入栈的值
     */
    public void push(int val) {
        // 新建节点
        ListNode n = new ListNode(val);

        // 把入栈的值作为链表的第一个节点
        n.next = head.next;
        head.next = n;
    }

    /**
     * 出栈操作
     *
     * @return 出栈的值，如果栈空，返回 Integer.MIN_VALUE
     */
    public int pop() {
        // 判断是否栈空
        if (head.next == null) {
            return Integer.MIN_VALUE;
        }

        ListNode n = head.next;
        head.next = n.next;

        return n.val;
    }
}



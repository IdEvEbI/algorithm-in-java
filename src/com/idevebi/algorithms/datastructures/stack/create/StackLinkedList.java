package com.idevebi.algorithms.datastructures.stack.create;

import com.idevebi.algorithms.datastructures.linkedList.ListNode;

/**
 * 使用链表实现栈
 */
public class StackLinkedList {
    /**
     * 链表头节点
     */
    private ListNode head;

    /**
     * 入栈操作
     *
     * @param val 入栈的值
     */
    public void push(int val) {
        // 新建节点
        ListNode n = new ListNode(val);

        if (head != null) {
            n.next = head;
        }
        head = n;
    }

    /**
     * 出栈操作
     *
     * @return 出栈的值，如果栈空，返回 Integer.MIN_VALUE
     */
    public int pop() {
        // 判断是否栈空
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        int res = head.val;
        head = head.next;

        return res;
    }
}



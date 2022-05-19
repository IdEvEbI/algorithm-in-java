package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 删除链表的倒数第 N 个结点
 *
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">https://leetcode.cn/problems/remove-nth-node-from-end-of-list/</a>
 */
public class Leetcode19RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.println(head);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 增加哨兵节点
        ListNode node = new ListNode(0);
        node.next = head;

        // 2. 计算链表长度
        int len = getListLength(head);

        // 3. 遍历链表找到倒数第 n 个结点的前置结点
        ListNode cur = node;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return node.next;
    }

    private static int getListLength(ListNode head) {
        int i = 0;
        for (; head != null; i++) {
            head = head.next;
        }
        return i;
    }
}

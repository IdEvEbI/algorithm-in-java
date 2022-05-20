package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 反转链表
 *
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">https://leetcode.cn/problems/reverse-linked-list/</a>
 */
public class Leetcode206ReverseLinkedList {
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head = reverseList(head);

        System.out.println(head);
    }

    /**
     * 给定单链表的头节点 head，反转链表并返回反转后的链表 head。
     *
     * @param head 头节点
     * @return 翻转后的头节点
     */
    private static ListNode reverseList(ListNode head) {
        // 反转后的头指针
        ListNode rHead = null;

        // 当前头指针
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = rHead;
            rHead = cur;
            cur = next;
        }

        return rHead;
    }
}

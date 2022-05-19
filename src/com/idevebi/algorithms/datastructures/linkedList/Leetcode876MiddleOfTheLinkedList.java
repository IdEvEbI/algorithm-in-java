package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 链表的中间结点
 *
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">https://leetcode.cn/problems/middle-of-the-linked-list/</a>
 */
public class Leetcode876MiddleOfTheLinkedList {
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = middleNode(head);

        System.out.println(head);
    }

    private static ListNode middleNode(ListNode head) {
        // 定义快慢指针，快指针一次走一步，慢指针一次走两步
        ListNode slow = head;
        ListNode fast = head;

        // 遍历快指针是否到链表结尾
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 快指针到链尾，慢指针必然在链表中间
        return slow;
    }
}

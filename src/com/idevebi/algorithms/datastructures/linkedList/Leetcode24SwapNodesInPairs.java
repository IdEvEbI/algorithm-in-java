package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 两两交换链表中的节点
 *
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">https://leetcode.cn/problems/swap-nodes-in-pairs/</a>
 */
public class Leetcode24SwapNodesInPairs {
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = swapPairs(head);

        System.out.println(head);
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 创建哨兵节点
        ListNode n = new ListNode(0);
        n.next = head;

        // 操作节点
        ListNode cur = n;

        // 遍历链表
        while (cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;

            cur.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            cur = n1;
        }

        return n.next;
    }
}

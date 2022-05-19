package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 合并两个有序链表
 *
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">https://leetcode.cn/problems/merge-two-sorted-lists/</a>
 */
public class Leetcode21MergeTwoSortedLists {
    public static void main(String[] args) {
        // 创建链表
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode ans = mergeTwoLists(list1, list2);
        System.out.println(ans);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 哨兵节点
        ListNode n = new ListNode(0);

        ListNode cur = n;
        // 同时遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // 处理剩余链表
        cur.next = (list1 != null) ? list1 : list2;

        return n.next;
    }
}

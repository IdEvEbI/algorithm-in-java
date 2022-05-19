package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 环形链表
 *
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">https://leetcode.cn/problems/linked-list-cycle/</a>
 */
public class Leetcode141LinkedListCycle {
    public static void main(String[] args) {
        // 创建环形链表
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);

        head.next.next.next.next = head.next;

        boolean ans = hasCycle(head);

        System.out.println(ans);
    }

    private static boolean hasCycle(ListNode head) {
        // 判断是否具备环的条件
        if (head == null || head.next == null) {
            return false;
        }

        // 快慢节点
        ListNode slow = head;
        ListNode fast = head.next;

        // 遍历链表，如果快慢节点重合说明链表有环
        while (fast != null) {
            // 快指针的 next 为空说明到达链尾，不存在循环
            if (fast.next == null) {
                return false;
            }

            // 慢指针一次挪动一个节点，快指针一次挪动两个节点
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}

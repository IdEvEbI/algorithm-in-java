package com.idevebi.algorithms.datastructures.linkedList;

/**
 * K 个一组翻转链表
 *
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">https://leetcode.cn/problems/reverse-nodes-in-k-group/</a>
 */
public class Leetcode25ReverseNodesInKGroup {
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;
        head = reverseKGroup(head, k);

        System.out.println(head);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        // 创建哨兵节点
        ListNode n = new ListNode(0);
        n.next = head;

        // 每一组链表的 前置节点
        ListNode pre = n;

        // 遍历链表
        while (true) {
            // 从前置节点开始查找每一组的尾结点
            ListNode tail = pre;

            // 查找每一组的 尾结点
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }

            // TODO: 提示：此处需要调试确认 tail 正确
            if (tail == null) {
                break;
            }

            // 记录翻转前的 头节点 和 下一个头结点
            ListNode kHead = pre.next;
            ListNode nextHead = tail.next;

            // 切断链表，方便翻转
            tail.next = null;
            // 翻转分组节点
            pre.next = reverse(kHead);

            kHead.next = nextHead;
            pre = kHead;
        }

        return n.next;
    }

    /**
     * 简化版的翻转链表
     */
    private static ListNode reverse(ListNode head) {
        // 翻转后的头结点
        ListNode rHead = null;

        // 当前头结点
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

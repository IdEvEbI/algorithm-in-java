package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

        ListNode head = LinkedListHelper.createTestList();

        head = solution.removeNthFromEnd(head, 2);
        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            return removeWithTwoPoint(head, n);
        }

        /**
         * 方法 2：双指针
         * <p>
         * 1. 同时准备两个指针
         * 2. fast 比 slow 超前 n 个结点
         * 3. fast 到链表尾部时，slow 刚好到达要删除位置之前的节点
         */
        private ListNode removeWithTwoPoint(ListNode head, int n) {
            // 1. 增加哨兵节点
            ListNode node = new ListNode(0, head);
            ListNode fast = head;
            ListNode slow = node;

            // 2. 先移动 fast 指针 n 次
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            // 3. 同时移动两个指针，直到 fast 到达链表尾部
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // 4. 删除节点
            slow.next = slow.next.next;

            return node.next;
        }

        /**
         * 方法 1：计算链表长度
         */
        private ListNode removeWithListLength(ListNode head, int n) {
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

        private int getListLength(ListNode head) {
            int i = 0;
            for (; head != null; i++) {
                head = head.next;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode head = solution.addTwoNumbers(l1, l2);
        System.out.println(head.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 结果列表的哨兵节点
            ListNode head = new ListNode(0);
            // 操作节点
            ListNode n = head;

            // 进位
            int carry = 0;

            // 同时遍历两个链表（两个链表的长度有可能不同）
            while (l1 != null || l2 != null) {
                int v1 = l1 != null ? l1.val : 0;
                int v2 = l2 != null ? l2.val : 0;

                int sum = v1 + v2 + carry;
                carry = sum / 10;
                n.next = new ListNode((sum % 10));
                n = n.next;

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            n.next = carry > 0 ? new ListNode(carry) : null;

            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
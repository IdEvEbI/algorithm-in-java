package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 203. 移除链表元素
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();

        ListNode head = LinkedListHelper.createTestList();

        head = solution.removeElements(head, 3);
        System.out.println(head.val);

        head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);

        head = solution.removeElements(head, 7);
        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 链表中有可能有重复节点，需要完整遍历链表
         */
        public ListNode removeElements(ListNode head, int val) {
            // 哨兵节点
            ListNode n = new ListNode(0);

            n.next = head;

            // 当前处理节点
            ListNode cur = n;

            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return n.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
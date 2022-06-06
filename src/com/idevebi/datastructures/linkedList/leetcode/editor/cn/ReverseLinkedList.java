package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 206. 反转链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

        ListNode head = LinkedListHelper.createTestList();

        head = solution.reverseList(head);
        System.out.println(head.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode reverseList(ListNode head) {
            // 翻转后的头指针
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
//leetcode submit region end(Prohibit modification and deletion)

}
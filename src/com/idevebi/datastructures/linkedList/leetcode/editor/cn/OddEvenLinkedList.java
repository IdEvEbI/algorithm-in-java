package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 328. 奇偶链表
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();

        ListNode head = LinkedListHelper.createTestList();
        solution.oddEvenList(head);
        System.out.println(head.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            // 偶数节点头指针
            ListNode evenHead = head.next;
            // 奇数指针 & 偶数指针
            ListNode odd = head;
            ListNode even = evenHead;

            // 遍历链表，按照奇数和偶数拆分成两个链表
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;

                even.next = odd.next;
                even = even.next;
            }
            // 拼接链表
            odd.next = evenHead;

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
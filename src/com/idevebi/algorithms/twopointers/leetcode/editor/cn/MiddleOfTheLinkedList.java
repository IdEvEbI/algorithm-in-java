package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 876. 链表的中间结点
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();

        ListNode head = LinkedListHelper.createTestList();

        head = solution.middleNode(head);
        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode middleNode(ListNode head) {
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
//leetcode submit region end(Prohibit modification and deletion)

}
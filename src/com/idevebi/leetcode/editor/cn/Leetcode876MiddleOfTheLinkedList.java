package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.linkedList.ListNode;
import com.idevebi.leetcode.editor.cn.util.LinkedListHelper;

public class Leetcode876MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new Leetcode876MiddleOfTheLinkedList().new Solution();

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
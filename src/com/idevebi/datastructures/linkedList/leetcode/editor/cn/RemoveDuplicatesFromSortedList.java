package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 83. 删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

        // 测试 1
        ListNode n = LinkedListHelper.createTestList();
        ListNode head = new ListNode(1, n);

        head = solution.deleteDuplicates(head);
        System.out.println(head.val);

        // 测试 2
        head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head = solution.deleteDuplicates(head);

        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode n = head;
            while (n != null && n.next != null) {
                if (n.val == n.next.val) {
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
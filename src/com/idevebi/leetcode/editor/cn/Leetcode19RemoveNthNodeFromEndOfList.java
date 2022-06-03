package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

public class Leetcode19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Leetcode19RemoveNthNodeFromEndOfList().new Solution();

        ListNode head = LinkedListHelper.createTestList();

        head = solution.removeNthFromEnd(head, 2);
        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
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
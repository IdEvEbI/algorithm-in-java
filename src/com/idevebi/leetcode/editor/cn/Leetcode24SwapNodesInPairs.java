package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.linkedList.ListNode;
import com.idevebi.leetcode.editor.cn.util.LinkedListHelper;

public class Leetcode24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new Leetcode24SwapNodesInPairs().new Solution();

        ListNode head = LinkedListHelper.createTestList();
        head = solution.swapPairs(head);

        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 创建哨兵节点
            ListNode n = new ListNode(0);
            n.next = head;

            // 操作节点
            ListNode cur = n;

            // 遍历链表
            while (cur.next != null && cur.next.next != null) {
                ListNode n1 = cur.next;
                ListNode n2 = cur.next.next;

                cur.next = n2;
                n1.next = n2.next;
                n2.next = n1;
                cur = n1;
            }

            return n.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
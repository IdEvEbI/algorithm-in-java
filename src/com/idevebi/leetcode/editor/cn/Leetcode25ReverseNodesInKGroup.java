package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.linkedList.ListNode;
import com.idevebi.leetcode.editor.cn.util.LinkedListHelper;

public class Leetcode25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Leetcode25ReverseNodesInKGroup().new Solution();

        ListNode head = LinkedListHelper.createTestList();
        head = solution.reverseKGroup(head, 3);

        System.out.println(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // 创建哨兵节点
            ListNode n = new ListNode(0);
            n.next = head;

            // 每一组链表的前置节点
            ListNode pre = n;

            // 遍历链表
            while (true) {
                // 1. 从前置节点开始查找每一组的尾结点
                ListNode tail = pre;

                for (int i = 0; i < k && tail != null; i++) {
                    tail = tail.next;
                }

                // 链表遍历结束，退出循环
                if (tail == null) {
                    break;
                }

                // 2. 翻转 pre -> tail 这一小段链表
                // 2.1 头节点 和 下一段的头节点
                ListNode kHead = pre.next;
                ListNode nextHead = tail.next;
                // 2.2 切断链表，方便翻转（关键）
                tail.next = null;
                // 2.3 翻转链表
                pre.next = reverse(kHead);

                // 2.3 更新分段链表的头节点
                kHead.next = nextHead;
                pre = kHead;
            }

            return n.next;
        }

        private ListNode reverse(ListNode head) {
            // 翻转后的头节点
            ListNode rHead = null;

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
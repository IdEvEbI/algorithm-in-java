package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;

public class Leetcode21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Leetcode21MergeTwoSortedLists().new Solution();

        // 创建链表
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        list1 = solution.mergeTwoLists(list1, list2);

        System.out.println(list1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 哨兵节点
            ListNode n = new ListNode(0);

            ListNode cur = n;
            // 同时遍历两个链表
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            // 处理剩余链表
            cur.next = (list1 != null) ? list1 : list2;

            return n.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
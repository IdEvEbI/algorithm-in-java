package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 141. 环形链表
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();

        ListNode head = LinkedListHelper.createTestCycleList();
        System.out.println(solution.hasCycle(head));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 判断是否具备环的条件
            if (head == null || head.next == null) {
                return false;
            }

            // 快慢节点
            ListNode slow = head;
            ListNode fast = head.next;

            // 遍历链表，如果快慢节点重合说明链表有环
            while (fast != null) {
                // 快指针的 next 为空说明到达链尾，不存在循环
                if (fast.next == null) {
                    return false;
                }

                // 慢指针一次挪动一个节点，快指针一次挪动两个节点
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
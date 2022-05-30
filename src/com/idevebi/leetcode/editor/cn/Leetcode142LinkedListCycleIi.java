package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.linkedList.ListNode;
import com.idevebi.leetcode.editor.cn.util.LinkedListHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * 参考资料：<a href="https://leetcode.cn/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/">https://leetcode.cn/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/</a>
 */
public class Leetcode142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new Leetcode142LinkedListCycleIi().new Solution();

        ListNode head = LinkedListHelper.createTestCycleList();
        System.out.println(solution.detectCycle(head));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        /**
         * 快慢指针解题，需要数学计算，空间复杂度 O(1)
         */
        public ListNode detectCycle(ListNode head) {
            // 判断是否具备环的条件
            if (head == null || head.next == null) {
                return null;
            }

            // 快慢节点
            ListNode slow = head;
            ListNode fast = head;

            // 遍历链表，如果快慢节点重合说明链表有环
            while (fast != null && fast.next != null) {
                // 慢指针一次挪动一个节点，快指针一次挪动两个节点
                slow = slow.next;
                fast = fast.next.next;

                // 有环
                if (fast == slow) {
                    ListNode n1 = fast; // 从当前位置出发
                    ListNode n2 = head; // 从头结点出发

                    while (n1 != n2) {
                        n1 = n1.next;
                        n2 = n2.next;
                    }

                    return n1;
                }
            }

            return null;
        }

        /**
         * 使用哈希表解题，思路简单，空间复杂度 N(n)
         */
        public ListNode detectCycle2(ListNode head) {
            // 定义集合记录所有曾经访问过的节点
            Set<ListNode> set = new HashSet<>();

            ListNode n = head;

            // 遍历链表
            while (n != null) {
                if (set.contains(n)) {
                    return n;
                } else {
                    set.add(n);
                }

                n = n.next;
            }

            // 遍历到链尾直接返回 null
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
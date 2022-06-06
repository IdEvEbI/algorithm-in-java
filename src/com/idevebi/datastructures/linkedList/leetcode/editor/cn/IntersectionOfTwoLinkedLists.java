package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * <p>
 * 参考资料：<a href=" https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/lian-biao-xiang-jiao-shuang-zhi-zhen-onshi-jian-fu"> https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/lian-biao-xiang-jiao-shuang-zhi-zhen-onshi-jian-fu</a>/
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();

        // 相交节点
        ListNode n = new ListNode(99);
        n.next = new ListNode(4);
        n.next.next = new ListNode(5);

        // 创建链表
        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = n;

        ListNode listB = new ListNode(9);
        listB.next = new ListNode(8);
        listB.next.next = new ListNode(7);
        listB.next.next.next = n;

        System.out.println(solution.getIntersectionNode(listA, listB).val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            return detectWithTwoPointers(headA, headB);
        }

        /**
         * 方法 2：双指针
         * <p>
         * 1. 指针 A：遍历 listA + listB
         * 2. 指针 B：遍历 listB + listA
         * <p>
         * 举例：
         * 1. listA: a + c
         * 2. listB: b + c
         * <p>
         * 指针 A 遍历 a + c + b
         * 指针 B 遍历 b + c + a
         * <p>
         * 则第 2 次遍历时，两个指针如果相遇，表示链表相交
         */
        private ListNode detectWithTwoPointers(ListNode headA, ListNode headB) {
            ListNode pA = headA;
            ListNode pB = headB;

            while (pA != pB) {
                pA = (pA == null) ? headB : pA.next;
                pB = (pB == null) ? headA : pB.next;
            }

            return pA;
        }

        /**
         * 方法 1：哈希 Set
         */
        private ListNode detectWithHashSet(ListNode headA, ListNode headB) {
            // 1. 哈希集合
            Set<ListNode> set = new HashSet<>();

            // 2. 扫描 ListA 并加入 set
            ListNode n = headA;
            while (n != null) {
                set.add(n);
                n = n.next;
            }

            // 2. 扫描 ListB 判断节点是否在哈希表中存在
            n = headB;
            while (n != null) {
                if (set.contains(n)) {
                    return n;
                }
                n = n.next;
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
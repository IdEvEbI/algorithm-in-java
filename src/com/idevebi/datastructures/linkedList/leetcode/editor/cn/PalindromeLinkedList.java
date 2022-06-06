package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();

        ListNode head = LinkedListHelper.createTestList();
        System.out.println(solution.isPalindrome(head));

        head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(5);
        System.out.println(solution.isPalindrome(head));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isPalindrome(ListNode head) {
            return checkWithReverse(head);
        }

        /**
         * 方法 2：翻转后半段链表
         */
        private boolean checkWithReverse(ListNode head) {
            // 1. 使用快慢指针找到链表的中间节点
            ListNode mid = middleNode(head);
            // 2. 把 mid 当做头节点，翻转后半段链表
            mid = reverseList(mid);

            // 3. 判断是否是回文
            ListNode n1 = head;
            ListNode n2 = mid;
            boolean ans = true;
            while (n2 != null) {
                if (n1.val != n2.val) {
                    ans = false;
                    break;
                }
                n1 = n1.next;
                n2 = n2.next;
            }

            // 4. Tips：还原链表（不还原会快一些，不过链表也会被破坏）
            // reverseList(mid);

            return ans;
        }

        private ListNode reverseList(ListNode head) {
            // 翻转后的头指针
            ListNode rHead = null;

            // 当前头指针
            ListNode cur = head;

            while (cur != null) {
                ListNode next = cur.next;

                cur.next = rHead;
                rHead = cur;
                cur = next;
            }

            return rHead;
        }

        private ListNode middleNode(ListNode head) {
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

        /**
         * 方法 1：使用列表判断
         */
        private boolean checkWithList(ListNode head) {
            List<Integer> nums = new ArrayList<>();

            // 将链表复制到列表中
            for (ListNode n = head; n != null; n = n.next) {
                nums.add(n.val);
            }

            // 使用双指针判断回文
            for (int l = 0, r = nums.size() - 1; l < r; l++, r--) {
                if (!nums.get(l).equals(nums.get(r))) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
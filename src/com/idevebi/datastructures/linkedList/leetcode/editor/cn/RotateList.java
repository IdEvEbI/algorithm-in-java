package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

/**
 * 61. 旋转链表
 */
public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();

        ListNode head = LinkedListHelper.createTestList();
        head = solution.rotateRight(head, 2);
        System.out.println(head.val);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 提示：由于 k 的值有可能非常大，不能使用快慢指针的方式找
         */
        public ListNode rotateRight(ListNode head, int k) {
            // 1. 条件检测
            if (k == 0 || head == null || head.next == null) {
                return head;
            }

            // 1. 计算链表长度
            int len = 1;
            ListNode n = head;
            while (n.next != null) {
                n = n.next;
                len++;
            }

            // 2. 计算旋转次数
            k = len - k % len;
            if (k == len) {
                return head;
            }

            // 3. 让链表闭合
            n.next = head;
            while (k > 0) {
                n = n.next;
                k--;
            }

            // 4. 切断链表
            head = n.next;
            n.next = null;

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
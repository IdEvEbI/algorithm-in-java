package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import com.idevebi.datastructures.linkedList.ListNode;
import com.idevebi.datastructures.util.LinkedListHelper;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

        ListNode head = LinkedListHelper.createTestList();
        int[] ans = solution.reversePrint(head);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] reversePrint(ListNode head) {
            return reverseWithTwiceLoop(head);
        }

        /**
         * 方法 2：两次遍历链表
         */
        private int[] reverseWithTwiceLoop(ListNode head) {
            ListNode n = head;

            // 1. 计算链表长度
            int len = 0;
            while (n != null) {
                len++;
                n = n.next;
            }

            // 2. 新建数组
            int[] ans = new int[len];

            // 3. 再次遍历链表，反向填充数组
            n = head;
            for (int i = len - 1; i >= 0; i--) {
                ans[i] = n.val;
                n = n.next;
            }

            return ans;
        }

        /**
         * 方法 1：使用 Stack 反转链表
         */
        private int[] reverseWithStack(ListNode head) {
            Stack<Integer> stack = new Stack<>();

            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }

            int[] ans = new int[stack.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = stack.pop();
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
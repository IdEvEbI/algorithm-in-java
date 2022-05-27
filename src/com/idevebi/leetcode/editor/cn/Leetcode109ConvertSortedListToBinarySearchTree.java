package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.linkedList.ListNode;
import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.LinkedListHelper;

public class Leetcode109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {

        ListNode head = LinkedListHelper.createTestList();

        Solution solution = new Leetcode109ConvertSortedListToBinarySearchTree().new Solution();

        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }

            // 1. 利用快慢指针，找到中间节点的值
            ListNode slow = head;
            ListNode fast = head;
            // 慢指针前一个节点，用于切断链表
            ListNode preSlow = null;

            // 快指针到链尾，慢指针刚好在链表中间
            while (fast != null && fast.next != null) {
                preSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2. 创建根节点
            TreeNode root = new TreeNode(slow.val);

            // 3. 切断链表，递归
            if (preSlow != null) {
                preSlow.next = null;
                root.left = sortedListToBST(head);
            }
            root.right = sortedListToBST(slow.next);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
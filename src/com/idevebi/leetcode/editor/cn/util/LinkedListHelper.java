package com.idevebi.leetcode.editor.cn.util;

import com.idevebi.leetcode.editor.cn.datastructures.linkedList.ListNode;

public class LinkedListHelper {
    /**
     * 创建测试链表
     * <p>
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * @return 头节点
     */
    public static ListNode createTestList() {
        ListNode head = new ListNode(1);

        ListNode cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);

            cur = cur.next;
        }

        return head;
    }
}

package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 设计链表（单链表）
 *
 * <a href="https://leetcode.cn/problems/design-linked-list/">https://leetcode.cn/problems/design-linked-list/</a>
 */
public class Leetcode707SingleList {
    public static void main(String[] args) {
        MySingleLinkedList linkedList = new MySingleLinkedList();

        linkedList.addAtIndex(0, 1);     // 链表变为 1
        linkedList.addAtIndex(1, 2);     // 链表变为 1 -> 2
        linkedList.addAtIndex(2, 3);     // 链表变为 1 -> 2 -> 3

        linkedList.addAtHead(99);              // 链表变为 99 -> 1 -> 2 -> 3
        linkedList.addAtTail(4);               // 链表变为 99 -> 1 -> 2 -> 3 -> 4

        System.out.println(linkedList.get(0));     // 返回 99
        linkedList.deleteAtIndex(1);               // 现在链表是 99 -> 2 -> 3 -> 4
        System.out.println(linkedList.get(0));     // 返回 99
    }
}

/**
 * 链表节点
 */
class SingleListNode {
    int val;
    SingleListNode next;

    SingleListNode(int val) {
        this.val = val;
    }
}

/**
 * 单链表
 */
class MySingleLinkedList {
    // 链表长度
    int size;
    // 头指针，哨兵节点（伪头）
    SingleListNode head;

    /**
     * 构造器
     */
    public MySingleLinkedList() {
        size = 0;
        head = new SingleListNode(0);
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回 -1
     *
     * @param index 索引
     * @return 第 index 个节点的值，如果索引无效，则返回 -1
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        SingleListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
     *
     * @param val 新值
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     *
     * @param val 新值
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点
     * <p>
     * - 如果 index 等于链表的长度，则该节点将附加到链表的末尾
     * - 如果 index 大于链表长度，则不会插入节点
     * - 如果 index 小于0，则在头部插入节点
     *
     * @param index 索引
     * @param val   值
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }

        // 遍历链表到 index 位置
        SingleListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        // 添加节点
        SingleListNode n = new SingleListNode(val);
        n.next = cur.next;
        cur.next = n;

        // 增加链表长度
        size++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点
     *
     * @param index 索引
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        SingleListNode n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        n.next = n.next.next;

        // 减少链表长度
        size--;
    }
}

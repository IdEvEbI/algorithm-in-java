package com.idevebi.algorithms.datastructures.linkedList;

/**
 * 设计链表（双链表）
 *
 * <a href="https://leetcode.cn/problems/design-linked-list/">https://leetcode.cn/problems/design-linked-list/</a>
 */
public class Leetcode707DoubleList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);    // 链表变为 1 -> 2 -> 3
        System.out.println(linkedList.get(0));    // 返回 1
        System.out.println(linkedList.get(1));    // 返回 2
        System.out.println(linkedList.get(2));    // 返回 3
        linkedList.deleteAtIndex(1);              // 现在链表是 1 -> 3
        System.out.println(linkedList.get(0));    // 返回 1
        System.out.println(linkedList.get(1));    // 返回 3
    }
}

/**
 * 链表节点
 */
class DoubleListNode {
    int val;
    DoubleListNode next;
    DoubleListNode prev;

    DoubleListNode(int val) {
        this.val = val;
    }
}

/**
 * 双链表
 */
class MyLinkedList {
    // 链表长度
    int size;
    // 头指针，哨兵节点
    DoubleListNode head;
    // 尾指针，哨兵节点
    DoubleListNode tail;

    /**
     * 构造器
     */
    public MyLinkedList() {
        size = 0;
        head = new DoubleListNode(999);
        tail = new DoubleListNode(-999);
        head.next = tail;
        tail.prev = head;
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

        // 根据 index 值决定从前还是从后遍历链表
        DoubleListNode cur = head.next;
        if (index < size - index) {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        }

        return cur.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
     *
     * @param val 新值
     */
    public void addAtHead(int val) {
        DoubleListNode n = new DoubleListNode(val);

        n.next = head.next;
        n.prev = head;

        head.next.prev = n;
        head.next = n;

        size++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     *
     * @param val 新值
     */
    public void addAtTail(int val) {
        DoubleListNode n = new DoubleListNode(val);

        n.next = tail;
        n.prev = tail.prev;

        tail.prev.next = n;
        tail.prev = n;

        size++;
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

        // 遍历链表到 index 位置的前、后节点
        DoubleListNode pNode, nNode;

        if (index < size - index) {
            pNode = head;
            for (int i = 0; i < index; i++) {
                pNode = pNode.next;
            }
            nNode = pNode.next;
        } else {
            nNode = tail;
            for (int i = 0; i < size - index; i++) {
                nNode = nNode.prev;
            }
            pNode = nNode.prev;
        }

        // 添加节点
        DoubleListNode n = new DoubleListNode(val);

        n.prev = pNode;
        n.next = nNode;

        pNode.next = n;
        nNode.prev = n;

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

        // 根据 index 值决定从前还是从后遍历链表
        DoubleListNode cur = head.next;
        if (index < size - index) {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        // 减少链表长度
        size--;
    }
}

package com.idevebi.algorithmsBak.datastructures.queue.create;

import com.idevebi.datastructures.linkedList.ListNode;

/**
 * 使用链表实现队列
 */
public class QueueLinkedList {
    /**
     * 队列头节点
     */
    ListNode front;
    /**
     * 队列尾结点
     */
    ListNode rear;

    /**
     * 入队操作
     *
     * @param val 入队的值
     */
    void enqueue(int val) {
        // 新建节点
        ListNode n = new ListNode(val);

        // 判断队尾指针是否为空，如果是，说明当前是空队列
        if (rear == null) {
            front = rear = n;
        } else {
            // 队尾指向新的节点
            rear.next = n;
            rear = n;
        }
    }

    /**
     * 出队操作
     *
     * @return 出队的值
     */
    int dequeue() {
        // 如果头节点为空，表示队列为空
        if (front == null) {
            return Integer.MIN_VALUE;
        }

        // 移动头指针
        ListNode n = front;
        front = front.next;

        // 注意：如果头指针为空，需要同时修改尾指针
        if (front == null) {
            rear = null;
        }

        // 返回出队的值
        return n.val;
    }
}

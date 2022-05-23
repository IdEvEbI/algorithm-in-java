package com.idevebi.algorithms.datastructures.queue.leetcode;

/**
 * 设计循环双端队列
 *
 * <a href="https://leetcode.cn/problems/design-circular-deque/">https://leetcode.cn/problems/design-circular-deque/</a>
 */
public class LC641DesignCircularDequeLinkedList {
    public static void main(String[] args) {
        MyCircularDequeLinkedList circularDeque = new MyCircularDequeLinkedList(3);

        // true true true false
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));

        // 2 true true true 4
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }
}

/**
 * 双端队列链表节点
 */
class DequeListNode {
    /**
     * 节点值
     */
    int val;
    /**
     * next 指针
     */
    DequeListNode next;

    /**
     * 构造器
     *
     * @param val 节点值
     */
    public DequeListNode(int val) {
        this.val = val;
    }
}

class MyCircularDequeLinkedList {
    /**
     * 队列容量
     */
    int capacity;
    /**
     * 队列头节点
     */
    DequeListNode front;
    /**
     * 队列尾结点
     */
    DequeListNode rear;
    /**
     * 队列节点计数
     */
    int count;

    public MyCircularDequeLinkedList(int k) {
        this.capacity = k;
    }

    /**
     * 将一个元素添加到双端队列头部
     *
     * @param value 插入的值
     * @return 是否成功
     */
    public boolean insertFront(int value) {
        return insertValue(value, true);
    }

    /**
     * 将一个元素添加到双端队列尾部
     *
     * @param value 插入的值
     * @return 是否成功
     */
    public boolean insertLast(int value) {
        return insertValue(value, false);
    }

    /**
     * 将元素插入双端队列
     *
     * @param value   插入的值
     * @param isFront 是否从头部插入
     * @return 是否成功
     */
    private boolean insertValue(int value, boolean isFront) {
        // 队列是否已满
        if (isFull()) {
            return false;
        }

        // 新建节点
        DequeListNode n = new DequeListNode(value);
        count++;

        // 判断队列是否为空
        if (isEmpty()) {
            front = rear = n;
            return true;
        }

        // 判断是否从对头插入
        if (isFront) {
            // 队头设置为新节点
            n.next = front;
            front = n;
        } else {
            // 队尾指向新节点
            rear.next = n;
            rear = n;
        }
        return true;
    }

    /**
     * 从双端队列头部删除一个元素
     *
     * @return 是否成功
     */
    public boolean deleteFront() {
        return deleteValue(true);
    }

    /**
     * 从双端队列尾部删除一个元素
     *
     * @return 是否成功
     */
    public boolean deleteLast() {
        return deleteValue(false);
    }

    /**
     * 从双端队列删除一个元素
     *
     * @param isFront 是否从头部删除
     * @return 是否成功
     */
    private boolean deleteValue(boolean isFront) {
        // 队列是否为空
        if (isEmpty()) {
            return false;
        }

        count--;
        // 如果节点数为空，清空头尾指针并返回
        if (count == 0) {
            front = rear = null;
            return true;
        }

        if (isFront) {
            front = front.next;
        } else {
            // 遍历链表
            DequeListNode n = front;
            while (n.next != rear) {
                n = n.next;
            }

            n.next = null;
            rear = n;
        }

        return true;
    }

    /**
     * 获得双端队列的第一个元素
     *
     * @return 第一个元素的值，队列为空返回 -1
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.val;
    }

    /**
     * 获得双端队列的最后一个元素
     *
     * @return 最后一个元素的值，队列为空返回 -1
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.val;
    }

    /**
     * 判断双端队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        // 队尾指针为空
        return rear == null;
    }

    /**
     * 判断双端队列是否已满
     *
     * @return 队列是否已满
     */
    public boolean isFull() {
        // 节点数等于队列容量
        return count == capacity;
    }
}

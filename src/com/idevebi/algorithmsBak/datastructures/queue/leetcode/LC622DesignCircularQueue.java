package com.idevebi.algorithmsBak.datastructures.queue.leetcode;

/**
 * 设计循环队列
 *
 * <a href="https://leetcode.cn/problems/design-circular-queue/">https://leetcode.cn/problems/design-circular-queue/</a>
 */
public class LC622DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        for (int i = 1; i < 5; i++) {
            System.out.println(circularQueue.enQueue(i));
        }
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
    }
}

class MyCircularQueue {
    /**
     * 元素数组
     */
    int[] items;
    /**
     * 队列容量
     */
    int capacity;
    /**
     * 队列头
     */
    int front;
    /**
     * 队列尾
     */
    int rear;
    /**
     * 队列大小
     */
    int size;

    /**
     * 构造器
     *
     * @param k 队列长度
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.items = new int[k];

        this.front = this.size = 0;
        this.rear = capacity - 1;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真。
     *
     * @param value 入队的值
     * @return 是否成功
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        items[rear] = value;
        size++;

        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真。
     *
     * @return 是否成功
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1。
     *
     * @return 队首元素值
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return items[front];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1。
     *
     * @return 队尾元素值
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return items[rear];
    }

    /**
     * 检查循环队列是否为空。
     *
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检查循环队列是否已满。
     *
     * @return 队列是否已满
     */
    public boolean isFull() {
        return size == capacity;
    }
}
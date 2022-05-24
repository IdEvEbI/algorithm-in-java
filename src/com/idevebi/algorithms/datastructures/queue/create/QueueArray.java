package com.idevebi.algorithms.datastructures.queue.create;

/**
 * 使用数组实现队列
 */
public class QueueArray {
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
     * @param capacity 队列容量
     */
    QueueArray(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.items = new int[capacity];
    }

    /**
     * 判断队列是否已满
     *
     * @return 队列是否已满
     */
    boolean isFull() {
        return size == capacity;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队操作
     *
     * @param val 入队的值
     * @return 是否成功，如果队列已满，返回 false
     */
    boolean enqueue(int val) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        // 将元素插入队尾
        items[rear] = val;
        size++;

        return true;
    }

    /**
     * 出队操作
     *
     * @return 出队的值，如果队列为空，返回 Integer.MIN_VALUE
     */
    int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int val = items[front];
        front = (front + 1) % capacity;
        size--;

        return val;
    }
}

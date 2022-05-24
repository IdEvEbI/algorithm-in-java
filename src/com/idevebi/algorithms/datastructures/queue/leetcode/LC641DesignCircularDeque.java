package com.idevebi.algorithms.datastructures.queue.leetcode;

/**
 * 设计循环双端队列
 *
 * <a href="https://leetcode.cn/problems/design-circular-deque/">https://leetcode.cn/problems/design-circular-deque/</a>
 */
public class LC641DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);

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

class MyCircularDeque {
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
     * 队列元素个数
     */
    int count;

    /**
     * 构造器
     *
     * @param k 双端队列容量
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.front = this.rear = this.count = 0;
        this.items = new int[k];
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
        if (isFull()) {
            return false;
        }

        if (isFront) {
            front = (front + capacity - 1) % capacity;
            items[front] = value;
        } else {
            items[rear] = value;
            rear = (rear + 1) % capacity;
        }

        count++;

        return true;
    }

    /**
     * 从双端队列头部删除一个元素
     *
     * @return 是否成功
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        count--;

        return true;
    }

    /**
     * 从双端队列尾部删除一个元素
     *
     * @return 是否成功
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear + capacity - 1) % capacity;
        count--;

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
        return items[front];
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
        return items[(rear + capacity - 1) % capacity];
    }

    /**
     * 判断双端队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 判断双端队列是否已满
     *
     * @return 队列是否已满
     */
    public boolean isFull() {
        return count == capacity;
    }
}

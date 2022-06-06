package com.idevebi.datastructures.queue.leetcode.editor.cn;

/**
 * 622. 设计循环队列
 */
public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue queue = new DesignCircularQueue().new MyCircularQueue(3);

        for (int i = 1; i < 5; i++) {
            boolean ans = queue.enQueue(i);
            System.out.println(i + " 入队 " + (ans ? "成功" : "失败"));
        }
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());

        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(66));
        System.out.println(queue.Rear());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
         * 头，从对头出队
         */
        int front;
        /**
         * 尾，从队尾入队
         */
        int rear;
        /**
         * 队列大小
         */
        int size;

        /**
         * 构造器
         */
        public MyCircularQueue(int k) {
            capacity = k;
            items = new int[k];

            front = size = 0;
            rear = capacity - 1;
        }

        /**
         * 向循环队列插入一个元素。如果成功插入则返回真。
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
         * 从队首获取元素。如果队列为空，返回 -1 。
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return items[front];
        }

        /**
         * 获取队尾元素。如果队列为空，返回 -1 。
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return items[rear];
        }

        /**
         * 检查循环队列是否为空。
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 检查循环队列是否已满。
         */
        public boolean isFull() {
            return size == capacity;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
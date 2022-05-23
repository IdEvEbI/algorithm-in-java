package com.idevebi.algorithms.datastructures.queue.create;

public class QueueLinkedListDemo {
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();

        for (int i = 0; i < 4; i++) {
            int val = i + 90;
            q.enqueue(val);

            System.out.println("数字 " + val + " 入队");
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("数字 " + q.dequeue() + " 出队");
        }
    }
}

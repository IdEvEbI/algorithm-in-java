package com.idevebi.algorithmsBak.datastructures.queue.create;

public class QueueArrayDemo {
    public static void main(String[] args) {
        QueueArray q = new QueueArray(3);

        for (int i = 0; i < 4; i++) {
            int val = i + 90;
            boolean isEnqueue = q.enqueue(val);
            System.out.println("数字 " + val + " 入队 " + (isEnqueue ? "成功" : "失败"));
        }

        for (int i = 0; i < 2; i++) {
            int val = q.dequeue();
            System.out.println("出队 " + (val != Integer.MIN_VALUE ? val : "失败"));
        }

        for (int i = 0; i < 3; i++) {
            int val = i + 80;
            boolean isEnqueue = q.enqueue(val);
            System.out.println("数字 " + val + " 入队 " + (isEnqueue ? "成功" : "失败"));
        }
    }
}

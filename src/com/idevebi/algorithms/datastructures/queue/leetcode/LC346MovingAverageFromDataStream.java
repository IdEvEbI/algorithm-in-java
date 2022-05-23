package com.idevebi.algorithms.datastructures.queue.leetcode;

/**
 * 数据流中的移动平均值
 *
 * <a href="https://leetcode.cn/problems/moving-average-from-data-stream/">https://leetcode.cn/problems/moving-average-from-data-stream/</a>
 */
public class LC346MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage win = new MovingAverage(3);

        System.out.println(win.next(1));
        System.out.println(win.next(10));
        System.out.println(win.next(3));
        System.out.println(win.next(5));
    }
}

/**
 * 移动平均值
 */
class MovingAverage {
    /**
     * 窗口大小
     */
    private final int size;
    /**
     * 数组队列
     */
    private final int[] queue;
    /**
     * 头指针位置
     */
    private int front;
    /**
     * 窗口中的计数
     */
    private int count;
    /**
     * 当前窗口中的数值总和
     */
    private double sum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
    }

    public double next(int val) {
        // 如果数字超出窗口大小，记录前一个值
        front = (front + 1) % size;
        int last = queue[front];

        // 入队
        queue[front] = val;

        count++;
        sum += val - last;

        // 返回平均值
        return sum / Math.min(size, count);
    }
}

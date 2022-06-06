package com.idevebi.datastructures.queue.leetcode.editor.cn;

/**
 * 346. 数据流中的移动平均值
 */
public class MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage win = new MovingAverageFromDataStream().new MovingAverage(3);

        System.out.println(win.next(1));
        System.out.println(win.next(10));
        System.out.println(win.next(3));
        System.out.println(win.next(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        /**
         * 窗口大小
         */
        int capacity;
        /**
         * 队列
         */
        int[] queue;
        /**
         * 窗口位置
         */
        int pos;
        /**
         * 当前窗口中的数值总和
         */
        int sum;

        public MovingAverage(int size) {
            capacity = size;
            queue = new int[size];
        }

        public double next(int val) {
            // 如果数字超出窗口大小，记录前一个值
            int front = pos % capacity;
            int last = queue[front];

            // 入队
            queue[front] = val;

            // 计算总和
            pos++;
            sum += val - last;

            // 返回平均值
            return (double) sum / Math.min(capacity, pos);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
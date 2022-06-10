package com.idevebi.datastructures.tree.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 */
public class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kth = new KthLargestElementInAStream().new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        PriorityQueue<Integer> priorityQueue;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.priorityQueue = new PriorityQueue<>();
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            // 入队
            priorityQueue.add(val);

            if (priorityQueue.size() > k) {
                // 优先队列的队头元素出队，保证队列大小为 k
                priorityQueue.poll();
            }

            return priorityQueue.peek();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.stack.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new ImplementStackUsingQueues().new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {

        // q1 负责存数据 + 出栈
        Queue<Integer> q1;
        // q2 负责入栈
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /**
         * 入栈
         */
        public void push(int x) {
            // 1. x 从 q2 入队
            q2.offer(x);

            // 2. q1 出队追加到 q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            // 3. 交换 q1 & q2
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        /**
         * 出栈
         */
        public int pop() {
            return q1.poll();
        }

        /**
         * 查看栈顶元素
         */
        public int top() {
            return q1.peek();
        }

        /**
         * 是否为空
         */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
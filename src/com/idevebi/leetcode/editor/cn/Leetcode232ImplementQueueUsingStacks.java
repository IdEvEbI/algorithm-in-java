package com.idevebi.leetcode.editor.cn;

import java.util.Stack;

public class Leetcode232ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new Leetcode232ImplementQueueUsingStacks().new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        // 使用两个栈实现
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        /**
         * 构造器
         */
        public MyQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        /**
         * 入队
         *
         * @param x 入队的值
         */
        public void push(int x) {
            this.inStack.push(x);
        }

        /**
         * 出队
         *
         * @return 出队的值
         */
        public int pop() {
            // 1. 如果 outStack 为空，将 inStack 的所有元素添加到 outStack
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }

            // 2. 从 outStack 出栈，模拟出队
            return outStack.pop();
        }

        /**
         * 队尾的值
         *
         * @return 队尾的值（不出队）
         */
        public int peek() {
            // 1. 如果 outStack 为空，将 inStack 的所有元素添加到 outStack
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }

            // 2. 返回 outStack 栈顶的值
            return outStack.peek();
        }

        /**
         * 判断是否队列空
         *
         * @return 是否队列空
         */
        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.stack.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new ImplementQueueUsingStacks().new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        Deque<Integer> inStack;
        Deque<Integer> outStack;

        /**
         * 构造器
         */
        public MyQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        /**
         * 入队
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * 出队
         */
        public int pop() {
            // 1. 如果 outStack 为空，将 inStack 的所有元素「搬」到 outStack
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            // 2. 从 outStack 出栈
            return outStack.pop();
        }

        /**
         * 栈顶的值
         */
        public int peek() {
            // 1. 如果 outStack 为空，将 inStack 的所有元素「搬」到 outStack
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            // 2. 返回 outStack 栈顶的值
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
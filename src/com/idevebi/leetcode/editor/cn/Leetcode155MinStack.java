package com.idevebi.leetcode.editor.cn;

import java.util.Stack;

public class Leetcode155MinStack {
    public static void main(String[] args) {
        MinStack minStack = new Leetcode155MinStack().new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        /**
         * 数据栈
         */
        private Stack<Integer> dataStack;
        /**
         * 最小栈
         */
        private Stack<Integer> minStack;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            dataStack.push(val);

            // 更新最小栈的值
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
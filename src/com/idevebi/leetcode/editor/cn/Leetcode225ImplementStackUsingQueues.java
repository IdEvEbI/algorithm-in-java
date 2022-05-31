package com.idevebi.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new Leetcode225ImplementStackUsingQueues().new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {

        // 使用两个队列实现
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        /**
         * 构造器
         */
        public MyStack() {
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        /**
         * 压栈
         *
         * @param x 入栈的值
         */
        public void push(int x) {
            // 1. 将 x 加入 q2
            q2.offer(x);

            // 2. 把 q1 顺序出队，重新添加到 q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            // 3. 交换 q1 和 q2
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        /**
         * 出栈
         *
         * @return 出栈的值
         */
        public int pop() {
            // 如果队列为空，remove 抛出异常，poll 返回 null
            return q1.poll();
        }

        /**
         * 栈顶的值，等价于 peek
         *
         * @return 栈顶的值（不出栈）
         */

        public int top() {
            return q1.peek();
        }

        /**
         * 判断是否栈空
         *
         * @return 是否栈空
         */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
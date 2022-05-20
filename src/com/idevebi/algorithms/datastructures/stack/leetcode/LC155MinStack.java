package com.idevebi.algorithms.datastructures.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈
 *
 * <a href="https://leetcode.cn/problems/min-stack/">https://leetcode.cn/problems/min-stack/</a>
 */
public class LC155MinStack {
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}

/**
 * 最小栈
 */
class MinStack {
    /**
     * 数据栈
     */
    private final Deque<Integer> dataStack;
    /**
     * 最小栈
     */
    private final Deque<Integer> minStack;

    /**
     * 构造器
     */
    public MinStack() {
        dataStack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 元素 val 入栈
     *
     * @param val 整数
     */
    public void push(int val) {
        dataStack.push(val);

        // 更新最小栈的值
        minStack.push(Math.min(minStack.peek(), val));
    }

    /**
     * 删除栈顶元素
     */
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    /**
     * 获取栈顶元素，不出栈
     *
     * @return 栈顶元素值
     */
    public int top() {
        return dataStack.peek();
    }

    /**
     * 获取栈中的最小元素
     *
     * @return 栈中的最小元素
     */
    public int getMin() {
        return minStack.peek();
    }
}

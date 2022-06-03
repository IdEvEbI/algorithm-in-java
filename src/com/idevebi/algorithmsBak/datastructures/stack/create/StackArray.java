package com.idevebi.algorithmsBak.datastructures.stack.create;

/**
 * 使用数组实现栈
 */
public class StackArray {
    /**
     * 元素数组
     */
    private final int[] items;
    /**
     * 栈的大小
     */
    private final int size;
    /**
     * 元素个数
     */
    private int count;

    /**
     * 构造器
     *
     * @param size 栈的大小
     */
    StackArray(int size) {
        this.items = new int[size];
        this.size = size;
        this.count = 0;
    }

    /**
     * 入栈操作
     *
     * @param val 入栈的值
     * @return 是否成功，如果栈已满，返回 false
     */
    public boolean push(int val) {
        // 判断是否栈满
        if (count == size) {
            return false;
        }
        // 在数组中保存数据
        items[count] = val;
        count++;

        return true;
    }

    /**
     * 出栈操作
     *
     * @return 出栈的值，如果栈为空，返回 Integer.MIN_VALUE
     */
    public int pop() {
        // 判断是否栈空
        if (count == 0) {
            return Integer.MIN_VALUE;
        }

        // 返回末尾元素
        return items[--count];
    }
}

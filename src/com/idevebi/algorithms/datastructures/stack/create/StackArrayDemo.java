package com.idevebi.algorithms.datastructures.stack.create;

public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray s = new StackArray(5);

        for (int i = 0; i < 6; i++) {
            boolean isPush = s.push(i);
            System.out.println("数字 " + i + " 入栈 " + (isPush ? "成功" : "失败"));
        }

        for (int i = 0; i < 6; i++) {
            int val = s.pop();
            System.out.println("出栈 " + (val != Integer.MIN_VALUE ? val : "失败"));
        }
    }
}

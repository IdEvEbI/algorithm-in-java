package com.idevebi.algorithmsBak.datastructures.stack.create;

public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();

        for (int i = 0; i < 6; i++) {
            s.push(i);
            System.out.println("数字 " + i + " 入栈");
        }

        for (int i = 0; i < 6; i++) {
            int val = s.pop();
            System.out.println("出栈 " + (val != Integer.MIN_VALUE ? val : "失败"));
        }
    }
}

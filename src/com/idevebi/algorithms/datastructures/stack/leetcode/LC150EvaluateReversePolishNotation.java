package com.idevebi.algorithms.datastructures.stack.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 *
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">https://leetcode.cn/problems/evaluate-reverse-polish-notation/</a>
 */
public class LC150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens;

        tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        // 定义操作数栈
        Deque<Integer> stack = new LinkedList<Integer>();

        // 遍历数组
        for (String token : tokens) {
            // 如果是整数，入栈
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // TODO: 如果是操作符，连续从栈中弹出两个数，并使用操作符计算
                // 从栈中弹出两个数字
                int n2 = stack.pop();
                int n1 = stack.pop();
                int r = 0;
                // 根据操作符计算结果
                switch (token) {
                    case "+" -> r = n1 + n2;
                    case "-" -> r = n1 - n2;
                    case "*" -> r = n1 * n2;
                    case "/" -> r = n1 / n2;
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                }
                // 把操作结果入栈
                stack.push(r);
            }
        }
        // 返回栈底结果
        return stack.pop();
    }

    /**
     * 判断字符串是否是数字，仅判断 +、-、*、/ 四个操作符
     */
    private static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token)
                || "*".equals(token) || "/".equals(token));
    }
}

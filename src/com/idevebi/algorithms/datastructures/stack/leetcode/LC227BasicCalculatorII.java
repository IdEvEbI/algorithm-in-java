package com.idevebi.algorithms.datastructures.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器 II
 *
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/">https://leetcode.cn/problems/basic-calculator-ii/</a>
 */
public class LC227BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("3+2 *2   "));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
    }

    private static int calculate(String s) {
        // 定义数据栈
        Deque<Integer> stack = new LinkedList<Integer>();

        // 前置运算符号
        char sign = '+';
        // 当前处理的数值
        int num = 0;
        // 字符串长度
        int len = s.length();

        // 从左至右遍历字符串
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            // 如果是数字，循环拼接数字，每次 * 10
            if (c >= '0') {
                num = num * 10 + c - '0';
            }

            // 运算处理（注意：结尾）
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == len - 1) {
                stack.push(switch (sign) {
                    case '+' -> num;
                    case '-' -> -num;
                    case '*' -> stack.pop() * num;
                    case '/' -> stack.pop() / num;
                    default -> throw new RuntimeException("运算符错误");
                });

                // 记录操作符
                sign = c;
                num = 0;
            }
        }

        // 循环累加栈中的结果
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}

package com.idevebi.algorithmsBak.datastructures.stack.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器 II
 *
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/">https://leetcode.cn/problems/basic-calculator-ii/</a>
 */
public class LC227BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("10 - 2 * 3 + 5 "));
        System.out.println(calculate("10 + 2*5/3+6/4 * 2 "));
        System.out.println(calculate("31+2 *2   "));
        System.out.println(calculate(" 3+5 / 2 "));
    }

    /**
     * 使用双栈实现
     */
    private static int calculate(String s) {
        // 数据栈
        Deque<Integer> dataStack = new LinkedList<>();
        // 操作符栈
        Deque<Character> opStack = new LinkedList<>();

        // 字符索引
        int i = 0;
        // 字符串长度
        int len = s.length();

        while (i < len) {
            char c = s.charAt(i);

            // 过滤空格
            if (c == ' ') {
                i++;
                continue;
            }

            // 1. 处理数字
            if (c >= '0') {
                int num = 0;
                for (; i < len && s.charAt(i) >= '0'; i++) {
                    num = 10 * num + s.charAt(i) - '0';
                }
                // 数字入栈
                dataStack.push(num);
            } else {
                // 2. 处理运算符
                // 2.1 如果已经有运算符，新遇到的运算符为 +、-，直接计算
                while (!opStack.isEmpty() && !priority(c, opStack.peek())) {
                    calc(dataStack, opStack);
                }

                // 2.2 新运算符入栈
                opStack.push(c);

                i++;
            }
        }

        // 3. 处理栈中剩余数据
        while (!opStack.isEmpty()) {
            calc(dataStack, opStack);
        }

        return dataStack.pop();
    }

    /**
     * 判断当前运算符 cur 和 栈顶运算符 top 的优先级
     */
    private static boolean priority(char cur, char top) {
        if (cur == '*' || cur == '/') {
            return (top == '+' || top == '-');
        }
        return false;
    }

    private static void calc(Deque<Integer> dataStack, Deque<Character> opStack) {
        int num2 = dataStack.pop();
        int num1 = dataStack.pop();
        char sign = opStack.pop();

        // 计算结果
        dataStack.push(switch (sign) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new RuntimeException("运算符错误");
        });
    }

    /**
     * 使用一个数据栈实现
     */
    private static int calculate2(String s) {
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

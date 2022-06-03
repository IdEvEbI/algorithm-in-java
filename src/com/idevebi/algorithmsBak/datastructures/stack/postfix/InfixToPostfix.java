package com.idevebi.algorithmsBak.datastructures.stack.postfix;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 中缀式转后缀式
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("10+(5-2)*2+10/2"));
        System.out.println(infixToPostfix("(10+(5-20/4)*2+10)/2"));
        System.out.println(infixToPostfix("10/2"));
    }

    /**
     * 把中缀表达式字符串转换成后缀表达式字符串
     *
     * @param exp 中缀表达式字符串
     * @return 后缀表达式字符串
     * <p>
     * 提示：没有处理 负数的情况，例如 -10/2
     * 参考视频：<a href="https://www.bilibili.com/video/BV1iz4y1k7Ct/">https://www.bilibili.com/video/BV1iz4y1k7Ct/</a>
     */
    private static String infixToPostfix(String exp) {

        // 结果表达式
        StringBuilder res = new StringBuilder();
        // 操作符栈
        Deque<Character> op = new LinkedList<>();

        // 遍历字符串
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // 1. 过滤空格
            if (c == ' ') {
            } else if (Character.isDigit(c)) {
                // 1. 处理数字
                res.append(c);
            } else if (c == '(') {
                // 4. 判断括号，( 直接入栈
                op.push(c);
            } else if (c == ')') {
                // 5. 处理括号
                // 5.1 把 ( 之前的操作符拼接到结果字符串中
                while (!op.isEmpty() && op.peek() != '(') {
                    res.append(' ');
                    res.append(op.pop());
                }
                // 5.2 直接把 ( 出栈
                op.pop();
            } else {
                // 2. 处理运算符
                // 2.0 在结果字符串中追加 空格
                res.append(' ');

                // 2.1 如果运算符栈不为空，同时新扫描的运算符的优先级不高于栈顶运算符
                // 例如：新扫描 +, 栈顶是 * => 弹栈
                while (!op.isEmpty() && priority(c) <= priority(op.peek())) {
                    res.append(op.pop());
                    res.append(' ');
                }
                // 2.2 其他情况，直接把操作符入栈
                op.push(c);
            }
        }

        // 3. 处理运算符栈中的剩余运算符
        while (!op.isEmpty()) {
            res.append(' ');
            res.append(op.pop());
        }

        return res.toString();
    }

    private static int priority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}

package com.idevebi.algorithms.datastructures.stack.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 *
 * <a href="https://leetcode.cn/problems/valid-parentheses/">https://leetcode.cn/problems/valid-parentheses/</a>
 */
public class LC20ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // 顺序遍历字符串中的字符
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

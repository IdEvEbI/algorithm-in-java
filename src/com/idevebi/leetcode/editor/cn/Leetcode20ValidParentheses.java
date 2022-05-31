package com.idevebi.leetcode.editor.cn;

import java.util.Stack;

public class Leetcode20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Leetcode20ValidParentheses().new Solution();

        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("([)]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

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
//leetcode submit region end(Prohibit modification and deletion)

}
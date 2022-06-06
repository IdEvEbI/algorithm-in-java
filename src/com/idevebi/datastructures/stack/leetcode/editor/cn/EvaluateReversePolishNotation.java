package com.idevebi.datastructures.stack.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();

        String[] tokens;

        tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens));

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(tokens));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();

            for (String str : tokens) {
                // 如果是数字，入栈
                if (isNumber(str)) {
                    stack.push(Integer.parseInt(str));
                } else {
                    // 从栈中连续弹出两个数字
                    int n2 = stack.pop();
                    int n1 = stack.pop();

                    // 根据操作符计算结果
                    int res = switch (str) {
                        case "+" -> n1 + n2;
                        case "-" -> n1 - n2;
                        case "*" -> n1 * n2;
                        case "/" -> n1 / n2;
                        default -> throw new RuntimeException("运算符错误");
                    };

                    // 操作结果入栈
                    stack.push(res);
                }
            }

            // 返回栈底结果
            return stack.pop();
        }

        private boolean isNumber(String str) {
            return !("+".equals(str) || "-".equals(str)
                    || "*".equals(str) || "/".equals(str));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
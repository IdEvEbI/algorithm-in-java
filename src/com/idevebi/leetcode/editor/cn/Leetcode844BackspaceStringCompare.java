package com.idevebi.leetcode.editor.cn;

import java.util.Stack;

public class Leetcode844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new Leetcode844BackspaceStringCompare().new Solution();

        System.out.println(solution.backspaceCompare("y#fo##f", "y#f#o##f"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
        System.out.println(solution.backspaceCompare("a#b#", "cd##"));
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("bxj##tw", "bxj###tw"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：双指针，核心思想（从后向前遍历字符串）
         */
        public boolean backspaceCompare(String s, String t) {
            // 字符串索引
            int sIdx = s.length() - 1;
            int tIdx = t.length() - 1;
            // 跳过字符计数
            int sSkip = 0;
            int tSkip = 0;

            // 从后向前遍历字符串
            while (sIdx >= 0 || tIdx >= 0) {
                // 调整 sIdx & sKip 取到第一个有效字符
                while (sIdx >= 0) {
                    if (s.charAt(sIdx) == '#') {
                        sSkip++;
                        sIdx--;
                    } else if (sSkip > 0) {
                        sSkip--;
                        sIdx--;
                    } else {
                        break;
                    }
                }

                // 调整 tIdx & tKip 取到第一个有效字符
                while (tIdx >= 0) {
                    if (t.charAt(tIdx) == '#') {
                        tSkip++;
                        tIdx--;
                    } else if (tSkip > 0) {
                        tSkip--;
                        tIdx--;
                    } else {
                        break;
                    }
                }

                // 比较字符
                if (sIdx >= 0 && tIdx >= 0) {
                    if (s.charAt(sIdx) != t.charAt(tIdx)) {
                        return false;
                    }
                } else if (sIdx >= 0 || tIdx >= 0) {
                    return false;
                }

                sIdx--;
                tIdx--;
            }

            return true;
        }

        /**
         * 方法 2：重组字符串（String API 练习）
         */
        public boolean backspaceCompare2(String s, String t) {
            return buildStr(s).equals(buildStr(t));
        }

        private String buildStr(String s) {
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '#') {
                    if (res.length() > 0) {
                        res.deleteCharAt(res.length() - 1);
                    }
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }

        /**
         * 方法 3：使用栈实现
         */
        public boolean backspaceCompare3(String s, String t) {
            // 1. 将字符串压入对战
            Stack<Character> sStack = strIntoStack(s);
            Stack<Character> tStack = strIntoStack(t);

            // 2. 比较两个栈的内容
            // 2.1 比较栈大小
            if (sStack.size() != tStack.size()) {
                return false;
            }
            // 2.2 遍历比较
            while (!sStack.empty()) {
                if (!sStack.pop().equals(tStack.pop())) {
                    return false;
                }
            }

            return true;
        }

        private Stack<Character> strIntoStack(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '#') {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
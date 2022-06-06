package com.idevebi.datastructures.stack.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 */
public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();

        System.out.println(solution.decodeString("2[abc]"));
        System.out.println(solution.decodeString("abc3[cd]xyz"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("3[ab2[bc]]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String decodeString(String s) {
            Deque<Integer> numStack = new LinkedList<>();
            Deque<String> strStack = new LinkedList<>();

            int times = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    times = times * 10 + c - '0';
                } else if (c == '[') {
                    numStack.push(times);
                    strStack.push(sb.toString());

                    times = 0;
                    sb.delete(0, sb.length());
                } else if (c == ']') {
                    int t = numStack.pop();
                    StringBuilder tmp = new StringBuilder(strStack.pop());
                    tmp.append(String.valueOf(sb).repeat(t));
                    sb = tmp;
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
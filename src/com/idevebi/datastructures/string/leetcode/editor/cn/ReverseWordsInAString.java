package com.idevebi.datastructures.string.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 颠倒字符串中的单词
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();

        System.out.println(solution.reverseWords(" a good   example  "));
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            return reverseInPlace(s);
        }

        /**
         * 方法 2：原地翻转
         */
        private String reverseInPlace(String s) {
            // 1. 将字符串转换成字符数组，以便实现原地翻转
            char[] chars = s.trim().toCharArray();

            // 2. 翻转整个字符串
            int left = 0;
            int end = chars.length;
            reverse(chars, left, end - 1);

            // 3. 扫描字符串把每个单词再做一次翻转
            int idx = 0;
            while (left < end) {
                // 1> 移除顶部空格
                while (chars[left] == ' ') {
                    left++;
                }
                // 2> 向右移动 p 指针，找到单词的分界位置
                int p = left;
                while (p < end && chars[p] != ' ') {
                    p++;
                }
                // 3> 翻转 left 和 p 之间的单词
                reverse(chars, left, p - 1);

                // 4> 搬移字符
                while (left < p) {
                    chars[idx++] = chars[left++];
                }

                // 5> 如果没有到末尾，增加一个空格
                if (idx < end) {
                    chars[idx++] = ' ';
                }
            }

            if (chars[idx - 1] == ' ') {
                idx--;
            }

            return new String(chars, 0, idx);
        }

        /**
         * 将 字符 数组 从 left ~ right 之间做翻转
         */
        private void reverse(char[] chars, int left, int right) {
            while (left < right) {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }

        /**
         * 方法 1：使用 API 反转字符串
         */
        private String reverseWithAPIs(String s) {
            List<String> list = Arrays.asList(s.trim().split("\\s+"));
            Collections.reverse(list);

            return String.join(" ", list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
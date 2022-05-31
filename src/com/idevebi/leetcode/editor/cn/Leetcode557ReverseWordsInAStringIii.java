package com.idevebi.leetcode.editor.cn;

public class Leetcode557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new Leetcode557ReverseWordsInAStringIii().new Solution();

        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("God Ding"));
        System.out.println(solution.reverseWords("IdevebI"));
        System.out.println(solution.reverseWords(""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：直接转换成字符数组，原地翻转
         */
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int len = s.length();

            for (int i = 0; i < len; i++) {
                int pre = i;

                // 在字符串中查找下一个 空格
                while (i < len && chars[i] != ' ') {
                    i++;
                }

                // 索引不同说明找到一个完整的单词
                if (i - pre > 1) {
                    // 原地翻转
                    reverse(chars, pre, i - 1);
                }
            }

            return String.valueOf(chars);
        }

        private void reverse(char[] chars, int l, int r) {
            while (l < r) {
                char tmp = chars[l];
                chars[l++] = chars[r];
                chars[r--] = tmp;
            }
        }

        /**
         * 方法 2：利用 StringBuilder 及 split API
         */
        public String reverseWords2(String s) {
            StringBuilder sb = new StringBuilder();

            // 1. 使用空格拆分字符串
            String[] arr = s.split(" ");

            // 2. 遍历字符串
            for (int i = 0; i < arr.length; i++) {
                // 将字符串转换成字符数组，原地翻转
                char[] chars = arr[i].toCharArray();

                for (int l = 0, r = arr[i].length() - 1; l < r; l++, r--) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                }

                sb.append(chars);
                if (i != arr.length - 1) {
                    sb.append(" ");
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
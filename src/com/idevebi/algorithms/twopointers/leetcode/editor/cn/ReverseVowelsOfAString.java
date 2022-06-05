package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

/**
 * 345. 反转字符串中的元音字母
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();

        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;

            for (int left = 0, right = len - 1; left < right; left++, right--) {
                // 1. 左侧元音
                char lc = chars[left];
                while (left < right && isNotLetter(lc)) {
                    lc = chars[++left];
                }

                // 2. 右侧元音
                char rc = chars[right];
                while (left < right && isNotLetter(rc)) {
                    rc = chars[--right];
                }

                if (left < right) {
                    char c = chars[left];
                    chars[left] = chars[right];
                    chars[right] = c;
                }
            }

            return new String(chars);
        }

        private boolean isNotLetter(char c) {
            return !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
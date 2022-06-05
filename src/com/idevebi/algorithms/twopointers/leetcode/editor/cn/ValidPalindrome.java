package com.idevebi.algorithms.twopointers.leetcode.editor.cn;

/**
 * 125. 验证回文串
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            return checkString(s);
        }

        /**
         * 方法 2：双指针
         */
        private boolean checkString(String s) {
            int len = s.length();

            for (int left = 0, right = len - 1; left < right; left++, right--) {
                // 1. 左侧有效字符
                char lc = s.charAt(left);
                while (left < right && !isLetterOrDigit(lc)) {
                    lc = s.charAt(++left);
                }

                // 2. 右侧有效字符
                char rc = s.charAt(right);
                while (left < right && !isLetterOrDigit(rc)) {
                    rc = s.charAt(--right);
                }

                // 3. 比较字符
                if (toLowerCase(lc) != toLowerCase(rc)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isLetterOrDigit(char c) {
            return ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
            );
        }

        private char toLowerCase(char c) {
            if ((c >= 'A' && c <= 'Z')) {
                return (char) (c + 32);
            }
            return c;
        }

        /**
         * 方法 1：使用 String Builder 处理字符串
         */
        private boolean checkWithStringBuilder(String s) {
            // 1. 处理字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }

            // 2. 判断是否是回文串
            int len = sb.length();
            for (int left = 0, right = len - 1; left < right; left++, right--) {
                if (sb.charAt(left) != sb.charAt(right)) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
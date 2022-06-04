package com.idevebi.datastructures.string.leetcode.editor.cn;

/**
 * 5. 最长回文子串
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("aacabdkacaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return fromCenter(s);
        }

        /**
         * 方法 3： 中心扩散
         */
        private String fromCenter(String s) {
            int strLen = s.length();
            int left = 0;
            int right = 0;

            int max = 0;
            int start = 0;

            // 扫描整个字符串
            for (int i = 0, len = 1; i < strLen; i++, len = 1) {
                // 每扫描一个字符，就分别向左、向右扫描回文
                left = i - 1;
                right = i + 1;

                // 分别向左右扫描字符串，查找相同字符
                while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                    len++;
                    left--;
                }
                while (right < strLen && s.charAt(right) == s.charAt(i)) {
                    len++;
                    right++;
                }
                while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                    len += 2;
                    left--;
                    right++;
                }

                // 更新记录
                if (len > max) {
                    max = len;
                    start = left + 1;
                }
            }

            return s.substring(start, start + max);
        }

        /**
         * 方法 2：最长公共子串
         * <p>
         * s = "abcb"
         * s.reverse = "bcba"
         * <p>
         * 最大回文串是 "bcb"
         */
        private String commonSubString(String s) {
            int len = s.length();

            // 翻转字符串
            String r = new StringBuilder(s).reverse().toString();
            int[][] arr = new int[len][len];

            // 公共子串最大长度
            int maxLen = 0;
            // 获得公共子串的结尾位置
            int maxEnd = 0;

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (s.charAt(i) == r.charAt(j)) {
                        // i == 0，扫描 s | j == 0，扫描 r
                        if (i == 0 || j == 0) {
                            arr[i][j] = 1;
                        } else {
                            arr[i][j] = arr[i - 1][j - 1] + 1;
                        }
                    }

                    if (arr[i][j] > maxLen) {
                        // !!! 特殊情况处理
                        int before = len - 1 - j;
                        if (before + arr[i][j] - 1 == i) {
                            maxLen = arr[i][j];
                            maxEnd = i + 1;
                        }
                    }
                }
            }

            return s.substring(maxEnd - maxLen, maxEnd);
        }

        /**
         * 方法 1：暴力解法
         */
        private String bruteForce(String s) {
            String ans = "";

            int max = 0;
            int len = s.length();

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    // 穷举所有的子串
                    String sub = s.substring(i, j);
                    // System.out.println(sub);

                    if (isPalindrome(sub) && sub.length() > max) {
                        ans = sub;
                        max = sub.length();
                    }
                }
            }

            return ans;
        }

        /**
         * 判断字符串是否是回文串
         */
        private boolean isPalindrome(String str) {
            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
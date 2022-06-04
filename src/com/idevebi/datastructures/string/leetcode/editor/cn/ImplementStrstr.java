package com.idevebi.datastructures.string.leetcode.editor.cn;

/**
 * 28. 实现 strStr()
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();

        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            return bruteForce(haystack, needle);
        }

        /**
         * 方法 1：暴力解法
         */
        private int bruteForce(String haystack, String needle) {
            int hLen = haystack.length();
            int nLen = needle.length();

            if (hLen < nLen) {
                return -1;
            }
            if (nLen == 0) {
                return 0;
            }
            // 扫描主串
            for (int i = 0; i < hLen - nLen + 1; i++) {
                int j;
                // 扫描匹配串
                for (j = 0; j < nLen; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nLen) {
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.string.leetcode.editor.cn;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            return horizontalScan(strs);
        }

        /**
         * 方法 2：纵向扫描，同时扫描数组中的每一个字符串
         */
        private String verticalScan(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            int len = strs[0].length();
            int count = strs.length;

            for (int i = 0; i < len; i++) {
                char c = strs[0].charAt(i);

                for (String str : strs) {
                    if (i == str.length() || str.charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }

            // strs[0] 全部扫描完，则公共前缀就是第 0 个字符串
            return strs[0];
        }

        /**
         * 方法 1：横向扫描，逐一比对每一个字符串
         */
        private String horizontalScan(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            // 第 0 个字符串作为公共前缀
            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                // 两两比较字符串，获取公共前缀
                prefix = lcp(prefix, strs[i]);

                // 如果扫描到没有公共前缀，退出并返回
                if (prefix.length() == 0) {
                    break;
                }
            }

            return prefix;
        }

        /**
         * 取两个字符串的公共前缀
         */
        private String lcp(String str1, String str2) {
            int len = Math.min(str1.length(), str2.length());

            int i = 0;
            while (i < len && str1.charAt(i) == str2.charAt(i)) {
                i++;
            }

            return str1.substring(0, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.string.leetcode.editor.cn;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();

        System.out.println(solution.reverseLeftWords("abcdefg", 2));
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         */
        public String reverseLeftWords(String s, int n) {
            return reverseWithSubString(s, n);
        }

        /**
         * 方法 2：使用 substring API
         */
        private String reverseWithSubString(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }

        /**
         * 方法 1：用与 [189. 轮转数组] 基本一致的思路
         * <p>
         * 1. 整体翻转
         * 2. 翻转左侧
         * 3. 翻转右侧
         */
        private String reverseThreeTimes(String s, int n) {
            char[] chars = s.toCharArray();
            int len = chars.length;

            // 1. 完整翻转
            reverse(chars, 0, len - 1);
            // 2. 翻转左侧
            reverse(chars, 0, len - 1 - n);
            // 3. 翻转右侧
            reverse(chars, len - n, len - 1);

            return new String(chars);
        }

        private void reverse(char[] chars, int left, int right) {
            while (left < right) {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
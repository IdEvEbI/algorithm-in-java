package com.idevebi.leetcode.editor.cn;

public class Leetcode387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new Leetcode387FirstUniqueCharacterInAString().new Solution();

        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("aabb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1： 直接遍历字符（题目规则 + API），不需要遍历字符串 O(1)
         */
        public int firstUniqChar(String s) {
            int ans = s.length();

            // 直接遍历字符
            for (char c = 'a'; c <= 'z'; c++) {
                // 判断字符串中是否包含该字符
                int idx = s.indexOf(c);

                if (idx != -1 && idx == s.lastIndexOf(c)) {
                    ans = Math.min(ans, idx);
                }
            }

            return ans == s.length() ? -1 : ans;
        }

        /**
         * 方法 2：利用题目规则 - 只有小写字母
         */
        public int firstUniqChar2(String s) {
            int[] letters = new int[26];

            // 1. 先扫描一遍字符串
            int len = s.length();
            for (int i = 0; i < len; i++) {
                letters[s.charAt(i) - 'a']++;
            }

            // 2. 再扫描一遍字符串，找到第一个计数为 1 的字符
            for (int i = 0; i < len; i++) {
                if (letters[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }

            return -1;
        }

        /**
         * 方法 3：利用字符串 API
         */
        public int firstUniqChar3(String s) {
            int len = s.length();

            for (int i = 0; i < len; i++) {
                if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
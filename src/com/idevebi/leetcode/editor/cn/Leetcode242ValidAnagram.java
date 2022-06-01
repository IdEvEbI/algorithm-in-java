package com.idevebi.leetcode.editor.cn;

public class Leetcode242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Leetcode242ValidAnagram().new Solution();

        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            // 异位词长度必须一致
            if (s.length() != t.length()) {
                return false;
            }

            // 字符字典
            int[] letters = new int[26];

            // 1. 先扫描字符串 s
            for (char c : s.toCharArray()) {
                letters[c - 'a']++;
            }

            // 2. 再扫描字符串 t，如果字典出现负数，说明字符不够
            for (char c : t.toCharArray()) {
                if (--letters[c - 'a'] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.leetcode.editor.cn;

public class Leetcode383RansomNote {
    public static void main(String[] args) {
        Solution solution = new Leetcode383RansomNote().new Solution();

        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            // 比较两个字符串长度，「杂志」字符串如果短，直接返回
            if (magazine.length() < ransomNote.length()) {
                return false;
            }

            // 建立字符数组，题目规则限制只有小写字母
            int[] letters = new int[26];

            // 1. 先扫描一遍「杂志」字符串
            for (int i = 0; i < magazine.length(); i++) {
                letters[magazine.charAt(i) - 'a']++;
            }

            // 2. 再扫描一遍「赎金信」字符串
            for (int i = 0; i < ransomNote.length(); i++) {
                int idx = ransomNote.charAt(i) - 'a';
                letters[idx]--;

                // 如果发现字符计数 < 0，说明「杂志」字符不够
                if (letters[idx] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
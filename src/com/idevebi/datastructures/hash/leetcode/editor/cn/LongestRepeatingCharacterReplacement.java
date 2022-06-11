package com.idevebi.datastructures.hash.leetcode.editor.cn;

/**
 * 424. 替换后的最长重复字符
 *
 * 参考资料：
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();

        System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int len = s.length();
            if (len < 2) {
                return len;
            }

            // 字符频率表
            int[] map = new int[26];
            int max = 0;

            char[] chars = s.toCharArray();

            // 滑动窗口扫描字符串
            int l = 0;
            int r = 0;

            for (; r < len; r++) {
                int idx = chars[r] - 'A';
                map[idx]++;
                max = Math.max(max, map[idx]);

                if (r - l + 1 > max + k) {
                    map[chars[l] - 'A']--;
                    l++;
                }
            }

            return r - l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
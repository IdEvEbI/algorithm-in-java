package com.idevebi.leetcode.editor.cn;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 题目链接：<a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">https://leetcode.cn/problems/longest-substring-without-repeating-characters/</a>
 * 参考文章：<a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/longest-substring-without-repeating-characters-b-2/">https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/longest-substring-without-repeating-characters-b-2/</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 字符表，记录一个字母后面出现重复时，左指针 i 应该调整到的新位置
            int[] m = new int[128];

            int res = 0;

            // 遍历右指针 j，左指针 i 根据 m 更新
            for (int i = 0, j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                i = Math.max(i, m[c]);
                m[c] = j + 1;

                res = Math.max(res, j - i + 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
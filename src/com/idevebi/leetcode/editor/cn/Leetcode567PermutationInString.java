package com.idevebi.leetcode.editor.cn;

public class Leetcode567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new Leetcode567PermutationInString().new Solution();

        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * s2 类似于秘钥字典，s1 类似于密文
         * <p>
         * 关键在于 s1 的字符可以任意组合，所以不能用字符串的 contains API
         */
        public boolean checkInclusion(String s1, String s2) {
            int s1len = s1.length();
            int s2len = s2.length();

            // 如果 s2 没有 s1 长，直接返回
            if (s2len < s1len) {
                return false;
            }

            // 定义字符集
            int[] letters = new int[26];

            // 1. 扫描 s1，生成字符字典
            for (char c : s1.toCharArray()) {
                letters[c - 'a']++;
            }

            // 2. 使用双指针扫描 s2
            int left = 0;
            char[] arr = s2.toCharArray();
            for (int right = 0; right < s2len; right++) {
                // 将字符集数字 - 1
                int idx = arr[right] - 'a';
                letters[idx]--;

                // 关键点：负数说明 s1 中不包含该字符
                // 回复字符表，并且移动左指针
                while (letters[idx] < 0) {
                    letters[arr[left] - 'a']++;
                    left++;
                }

                // 判断左右指针的区间是否仅包含 s1
                if (right - left + 1 == s1len) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
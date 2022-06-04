package com.idevebi.skills.leetcode.editor.cn;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new CheckIfOneStringSwapCanMakeStringsEqual().new Solution();

        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
        System.out.println(solution.areAlmostEqual("kelb", "kelb"));
        System.out.println(solution.areAlmostEqual("abcd", "dcba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int len = s1.length();

            int count = 0;
            int[] diff = new int[2];

            // 同时扫描两个字符串
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;

                    if (count > 2) {
                        // 超过两个字符不同，直接返回
                        return false;
                    } else {
                        diff[count - 1] = i;
                    }
                }
            }

            // 扫描完成，有三种种情况
            // 情况 1：两个字符串一致
            if (count == 0) {
                return true;
            }
            // 情况 2：比较两个字符交换的结果
            if (count == 2) {
                return (s1.charAt(diff[0]) == s2.charAt(diff[1])
                        &&
                        s1.charAt(diff[1]) == s2.charAt(diff[0]));
            }
            // 情况 3：其他返回 false
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
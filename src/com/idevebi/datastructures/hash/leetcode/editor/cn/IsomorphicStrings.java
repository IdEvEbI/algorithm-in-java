package com.idevebi.datastructures.hash.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();

        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("badc", "baba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            return checkWithCharMap(s, t);
        }

        /**
         * 方法 2：使用字符映射表（空间换时间）
         */
        private boolean checkWithCharMap(String s, String t) {
            int len = s.length();

            char[] map = new char[256];
            boolean[] recordMap = new boolean[256];

            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            for (int i = 0; i < len; i++) {
                char sc = sChars[i];
                char tc = tChars[i];

                if (map[sc] == 0 && !recordMap[tc]) {
                    map[sc] = tc;
                    recordMap[tc] = true;
                } else if (map[sc] != tc) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 方法 1：使用 HashSet 对比
         */
        private boolean checkWithHashSet(String s, String t) {
            Map<Character, Character> stMap = new HashMap<>();
            Map<Character, Character> tsMap = new HashMap<>();

            int len = s.length();
            char sC, tC;
            for (int i = 0; i < len; i++) {
                sC = s.charAt(i);
                tC = t.charAt(i);

                if (stMap.containsKey(sC) && stMap.get(sC) != tC) {
                    return false;
                }
                if (tsMap.containsKey(tC) && tsMap.get(tC) != sC) {
                    return false;
                }

                stMap.put(sC, tC);
                tsMap.put(tC, sC);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
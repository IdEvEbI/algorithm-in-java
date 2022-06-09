package com.idevebi.algorithms.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();

        System.out.println(solution.letterCasePermutation("a1b2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String s) {
            List<StringBuilder> ans = new ArrayList();

            ans.add(new StringBuilder());
            for (char c : s.toCharArray()) {
                int n = ans.size();
                if (Character.isLetter(c)) {
                    for (int i = 0; i < n; ++i) {
                        ans.add(new StringBuilder(ans.get(i)));
                        ans.get(i).append(Character.toLowerCase(c));
                        ans.get(n + i).append(Character.toUpperCase(c));
                    }
                } else {
                    for (int i = 0; i < n; ++i) {
                        ans.get(i).append(c);
                    }
                }
            }

            List<String> finalans = new ArrayList();
            for (StringBuilder sb : ans) {
                finalans.add(sb.toString());
            }

            return finalans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
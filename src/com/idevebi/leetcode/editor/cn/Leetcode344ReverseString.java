package com.idevebi.leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode344ReverseString {
    public static void main(String[] args) {
        Solution solution = new Leetcode344ReverseString().new Solution();

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));

        s = new char[]{};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            for (int l = 0, r = s.length - 1; l < r; l++, r--) {
                char c = s[l];
                s[l] = s[r];
                s[r] = c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.string.leetcode.editor.cn;

/**
 * 剑指 Offer 05. 替换空格
 */
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();

        System.out.println(solution.replaceSpace("We are happy."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();

            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(s.charAt(i));
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
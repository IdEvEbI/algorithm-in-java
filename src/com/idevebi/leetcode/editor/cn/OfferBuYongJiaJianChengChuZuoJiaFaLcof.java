package com.idevebi.leetcode.editor.cn;

public class OfferBuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new OfferBuYongJiaJianChengChuZuoJiaFaLcof().new Solution();

        System.out.println(solution.add(3, 5));
        System.out.println(solution.add(3, -5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法 1：循环
         * 加法运算 a + b 可以转换为 c + n，其中：
         * <p>
         * 1. 进位 c = (a & b) << 1;
         * 2. n = a ^ b
         */
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a = a ^ b;
                b = c;
            }

            return a;
        }

        /**
         * 方法 2：递归
         */
        public int add2(int a, int b) {
            if (b == 0) {
                return a;
            }

            int c = (a & b) << 1;
            a = a ^ b;
            b = c;

            return add(a, b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
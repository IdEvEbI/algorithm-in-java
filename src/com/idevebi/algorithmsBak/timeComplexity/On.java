package com.idevebi.algorithmsBak.timeComplexity;

/**
 * 时间复杂度 O(n) 示例
 */
public class On {
    public static void main(String[] args) {
        int n = 10;

        System.out.println(sum(n));
    }

    /**
     * 公式： T(n) = O(f(n))
     * 代码执行时间 T(n) = (3n + 3) * 单位时间
     * T(n) = O(3n + 3)
     * 时间复杂度：O(n)
     */
    private static int sum(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }
}

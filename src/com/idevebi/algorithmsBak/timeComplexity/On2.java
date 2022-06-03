package com.idevebi.algorithmsBak.timeComplexity;

/**
 * 时间复杂度 O(n^2) 示例
 */
public class On2 {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(sum(n));
    }

    /**
     * 公式： T(n) = O(f(n))
     * 代码执行时间 T(n) = (3n^2 + 3n + 3) * 单位时间
     * T(n) = O(3n^2 + 3n + 3)
     * 时间复杂度：O(n^2)
     */
    private static int sum(int n) {
        int result = 0;

        // 1 * 1 + 1 * 2 + 2 * 1 + 2 * 2 = 1 + 2 + 2 + 4 = 9
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result += i * j;
            }
        }

        return result;
    }
}

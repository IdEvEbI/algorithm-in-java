package com.idevebi.algorithms.timeComplexity;

/**
 * 时间复杂度 O(log n) 示例
 */
public class Ologn {
    public static void main(String[] args) {
        int n = 512;

        System.out.println(cal(n));
    }

    /**
     * log 以 2 为底 n 的对数
     * <p>
     * 不管是以 2 为底、以 3 为底，还是以其他为底，我们把所有对数阶的时间复杂度都记为 O(log n)
     */
    private static int cal(int n) {
        int i = 1;

        while (i < n) {
            System.out.println(i);
            i *= 2;
        }

        return i;
    }
}

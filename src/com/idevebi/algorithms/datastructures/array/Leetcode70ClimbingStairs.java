package com.idevebi.algorithms.datastructures.array;

/**
 * 爬楼梯
 *
 * <a href="https://leetcode.cn/problems/climbing-stairs/">https://leetcode.cn/problems/climbing-stairs/</a>
 */
public class Leetcode70ClimbingStairs {
    public static void main(String[] args) {
        int count = 6;

        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    /**
     * 每次可以爬 1 或 2 个台阶，一共 n 级台阶，一共有多少种爬法？
     *
     * @param n 台阶数量
     * @return 爬法数量
     * <p>
     * 说明：
     * 1. f(0) = 1 不用爬
     * 2. f(1) = 1 一步 1 个台阶
     * 3. f(2) = 2 一步 1 个 + 一步 2 个
     * 4. f(n) = f(n - 1) + f(n - 2) 斐波那契
     * <p>
     * 由于递归的时间复杂度太高，可以使用数组循环计算
     */
    private static int climbStairs(int n) {
        // 记录从 0 ~ n 所有的爬法数组
        int[] ans = new int[n + 1];

        ans[0] = 1;
        ans[1] = 1;

        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }

        return ans[n];
    }
}

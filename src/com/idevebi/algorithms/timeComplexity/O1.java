package com.idevebi.algorithms.timeComplexity;

/**
 * 时间复杂度 O(1) 示例
 * <p>
 * 常见时间复杂度：
 * <p>
 * 1. 常数阶 O(1)
 * 2. 对数阶 O(log n)
 * 3. 线性阶 O(n)
 * 4. 线性对数阶 O(n log n)
 * 5. 平方阶 O(n ^ 2)
 * 6. 指数阶 O(2 ^ n) 汉诺塔 / 斐波那契数列（优化前）
 * 7. 阶乘阶 O(n!)
 */
public class O1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(add(a, b));
    }

    /**
     * 只要代码的执行时间不随 n 的增大而增长，时间复杂度都记作 O(1)
     * <p>
     * 一般情况下，算法中如果不存在循环、递归，无论有多少行代码，时间复杂度都是Ο(1)
     */
    private static int add(int x, int y) {
        return x + y;
    }
}

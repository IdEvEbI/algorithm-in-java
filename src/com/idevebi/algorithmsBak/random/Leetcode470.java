package com.idevebi.algorithmsBak.random;

import java.util.Arrays;

/**
 * 用 Rand7() 实现 Rand10()
 *
 * <a href="https://leetcode.cn/problems/implement-rand10-using-rand7/">https://leetcode.cn/problems/implement-rand10-using-rand7/</a>
 */
public class Leetcode470 {
    public static void main(String[] args) {
        int times = 10000000;
        int[] counts = new int[10];

        for (int i = 0; i < times; i++) {
            counts[rand10() - 1]++;
        }

        System.out.println(Arrays.toString(counts));
    }

    /**
     * 只使用 rand7() 生成 [1, 10] 范围内的均匀随机整数
     *
     * @return [1, 10] 之间的一个整数
     */
    private static int rand10() {
        int row, col, idx;

        do {
            row = rand7();
            col = rand7();

            idx = col + (row - 1) * 7;
        } while (idx > 40);

        return 1 + (idx - 1) % 10;
    }

    /**
     * 可生成 [1, 7] 范围内的均匀随机整数
     *
     * @return [1, 7] 之间的一个整数
     */
    private static int rand7() {
        return (int) (Math.random() * 7) + 1;
    }
}

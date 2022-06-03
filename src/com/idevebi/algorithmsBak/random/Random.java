package com.idevebi.algorithmsBak.random;

import java.util.Arrays;

/**
 * 测试 Math.random 结果是 [0, 1) 之间等概率的一个值
 */
public class Random {
    public static void main(String[] args) {
        // testTimes();
        testRand8();
    }

    /**
     * 测试 Math.random() 的结果是 [0, 1) 之间等概率的一个值
     */
    private static void testTimes() {
        int times = 10000000;
        int count = 0;
        // 测试的种子数
        double seed = 0.75;

        for (int i = 0; i < times; i++) {
            if (Math.random() < seed) {
                count++;
            }
        }

        System.out.println((double) count / times);
    }

    /**
     * 测试 rand8() 可以可生成 [1, 8] 范围内的均匀随机整数
     */
    private static void testRand8() {
        int times = 10000000;
        int[] counts = new int[9];

        for (int i = 0; i < times; i++) {
            counts[rand8()]++;
        }

        System.out.println(Arrays.toString(counts));
    }

    /**
     * 可生成 [1, 8] 范围内的均匀随机整数
     *
     * @return [1, 8] 之间的一个整数
     */
    private static int rand8() {
        return (int) (Math.random() * 8) + 1;
    }
}

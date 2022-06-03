package com.idevebi.algorithmsBak.datastructures.array;

/**
 * 盛最多水的容器
 *
 * <a href="https://leetcode.cn/problems/container-with-most-water/">https://leetcode.cn/problems/container-with-most-water/</a>
 */
public class Leetcode11ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println(result);
    }

    /**
     * 给定一个长度为 n 的整数数组 height，找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
     *
     * @param height 高度数组
     * @return 返回容器可以储存的最大水量
     */
    private static int maxArea(int[] height) {
        int left = 0;                                   // 左边起始索引
        int right = height.length - 1;                  // 右边起始索引
        int max = 0;                                    // 初始最大面积

        // 遍历数组
        while (left < right) {
            // 使用 小的高度 * 宽 计算面积
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * (right - left);

            // 更新最大面积值
            max = Math.max(max, area);

            // 关键点：跳过低木板
            while (height[left] <= minHeight && left < right) {
                left++;
            }
            while (height[right] <= minHeight && left < right) {
                right--;
            }
        }

        return max;
    }
}

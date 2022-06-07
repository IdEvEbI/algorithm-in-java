package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 */
public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] res = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));

        nums1 = new int[]{4, 9, 5, 4, 4};
        nums2 = new int[]{9, 4, 9, 8, 4};

        res = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            return intersectWithHashArray(nums1, nums2);
        }

        /**
         * 方法 3：使用数组做哈希表（题目规则 数组长度 <= 1000 && num <= 1000）
         */
        private int[] intersectWithHashArray(int[] nums1, int[] nums2) {
            // 1. 比较两个数组长度，对长度小的数组做 hash
            if (nums1.length > nums2.length) {
                return intersectWithHashArray(nums2, nums1);
            }

            // 2. 定义 hash 数组
            int[] map = new int[1001];

            // 3. 扫描 nums1 建立哈希
            for (int n : nums1) {
                map[n]++;
            }

            // 4. 扫描 nums2 并填充结果
            int[] ans = new int[nums1.length];
            int idx = 0;
            for (int n : nums2) {
                if (map[n] > 0) {
                    ans[idx++] = n;
                    map[n]--;
                }
            }

            return Arrays.copyOfRange(ans, 0, idx);
        }

        /**
         * 方法 2：使用双指针
         */
        private int[] intersectWithTwoPoint(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int len1 = nums1.length;
            int len2 = nums2.length;

            int ans[] = new int[Math.min(len1, len2)];
            int idx = 0;

            for (int i = 0, j = 0; i < len1 && j < len2; ) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    ans[idx++] = nums1[i];
                    i++;
                    j++;
                }
            }

            return Arrays.copyOfRange(ans, 0, idx);
        }

        /**
         * 方法 1：使用 哈希表
         */
        private int[] intersectWithHashMap(int[] nums1, int[] nums2) {
            // 1. 比较两个数组长度，对长度小的数组做 hash
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }

            // 2. 扫描 nums1 并建立 hashmap
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums1) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            // 3. 扫描 nums2 并填充结果
            int[] ans = new int[nums1.length];
            int idx = 0;
            for (int n : nums2) {
                // 如果 哈希表 中存在该数字，并且计数 > 0
                int count = map.getOrDefault(n, 0);
                if (count > 0) {
                    // 添加到结果数组
                    ans[idx++] = n;
                    // 如果计数 == 1，从 哈希表 删除
                    if (count == 1) {
                        map.remove(n);
                    } else {
                        map.put(n, count - 1);
                    }
                }
            }

            // 4. 清理剩余空间
            return Arrays.copyOfRange(ans, 0, idx);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
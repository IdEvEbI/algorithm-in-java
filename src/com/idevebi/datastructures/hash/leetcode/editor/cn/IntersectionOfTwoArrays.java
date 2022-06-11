package com.idevebi.datastructures.hash.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();

        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};

        int[] res = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            // 判断数组长度
            if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
                return new int[0];
            }

            // 比较两个数组长度，对长度小的数组做 hash
            if (nums1.length > nums2.length) {
                return intersection(nums2, nums1);
            }

            // 新建一个 HashSet，将小数组中的数字添加到集合
            Set<Integer> s = new HashSet<>();
            for (int n : nums1) {
                s.add(n);
            }

            // 遍历 nums2，填充结果集合
            Set<Integer> ans = new HashSet<>();
            for (int n : nums2) {
                if (s.contains(n)) {
                    ans.add(n);
                }
            }

            // 创建结果数组
            int[] ansArr = new int[ans.size()];
            int idx = 0;
            for (int n : ans) {
                ansArr[idx++] = n;
            }

            return ansArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
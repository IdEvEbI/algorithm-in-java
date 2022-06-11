package com.idevebi.datastructures.hash.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 */
public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();

        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            return checkWithHashSet(nums, k);
        }

        /**
         * 方法 2：使用 HashSet 检查
         */
        private boolean checkWithHashSet(int[] nums, int k) {
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                // 从集合中删除不需要判断的元素，保证集合中的元素都满足 abs(i - j) <= k
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                // 添加失败说明集合中已经存在相同元素
                if (!set.add(nums[i])) {
                    return true;
                }
            }

            return false;
        }

        /**
         * 方法 1：使用 HashMap 检查
         */
        private boolean checkWithHashMap(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int n = nums[i];

                if (map.containsKey(n) && i - map.get(n) <= k) {
                    return true;
                }
                map.put(n, i);
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
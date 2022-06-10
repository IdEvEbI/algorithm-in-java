package com.idevebi.datastructures.tree.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 */
public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();

        System.out.println(solution
                .containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(solution
                .containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(solution
                .containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            return checkWithBucket(nums, k, t);
        }

        /**
         * 方法 3：桶排序
         */
        private boolean checkWithBucket(int[] nums, int k, int t) {
            int len = nums.length;
            if (len <= 1) {
                return false;
            }

            // 以 t + 1 为桶间距
            int size = t + 1;
            Map<Long, Long> map = new HashMap<>(len / size + 1);

            for (int i = 0; i < len; i++) {
                long val = (long) nums[i];

                // 桶编号
                long idx = getIdx(val, size);

                if (map.containsKey(idx)) {
                    return true;
                }
                long l = idx - 1;
                long r = idx + 1;
                if (map.containsKey(l) && val - map.get(l) <= t) {
                    return true;
                }
                if (map.containsKey(r) && map.get(r) - val <= t) {
                    return true;
                }

                map.put(idx, val);
                if (map.size() > k) {
                    map.remove(getIdx((long) nums[i - k], size));
                }
            }

            return false;
        }

        private long getIdx(long num, int size) {
            return num >= 0 ? num / size : ((num + 1) / size) - 1;
        }

        /**
         * 方法 2：使用 TreeSet 检查
         */
        private boolean checkWithTreeSet(int[] nums, int k, int t) {
            if (nums.length <= 1) {
                return false;
            }

            TreeSet<Long> set = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {
                long minVal = (long) nums[i] - t;
                long maxVal = (long) nums[i] + t;

                if (!set.isEmpty()) {
                    // 返回大于 minVal 的最小的值
                    Long numj = set.ceiling(minVal);
                    if (numj != null && numj <= maxVal) {
                        return true;
                    }
                }

                set.add((long) nums[i]);
                if (set.size() > k) {
                    set.remove((long) nums[i - k]);
                }
            }

            return false;
        }

        /**
         * 解法 1：暴力解法（超时）
         */
        private boolean bruteForce(int[] nums, int k, int t) {
            // 左窗口
            for (int left = 0; left < nums.length - 1; left++) {

                // 右窗口
                int right = Math.min(left + k + 1, nums.length);

                for (int i = left; i < right; i++) {
                    for (int j = i + 1; j < right; j++) {
                        long res = Math.abs((long) nums[i] - nums[j]);

                        if (res <= t) {
                            // System.out.println(nums[i] + "-" + nums[j] + " i " + i + " j " + j);
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
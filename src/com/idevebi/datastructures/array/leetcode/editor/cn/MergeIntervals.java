package com.idevebi.datastructures.array.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();

        int[][] intervals = {{1, 3}, {2, 6}, {0, 5}, {8, 10}, {15, 18}};
        intervals = solution.merge(intervals);

        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {

            // 1. 对数组排序
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            // 合并结果
            List<int[]> ans = new ArrayList<>();

            // 2. 遍历数组，合并区间
            for (int[] item : intervals) {
                int left = item[0];
                int right = item[1];

                int size = ans.size();
                // 没有元素 或者 末尾元素的 right < left 说明没有重叠，直接添加
                if (size == 0 || ans.get(size - 1)[1] < left) {
                    ans.add(new int[]{left, right});
                } else {
                    // 使用更大的 right 更新列表末尾元素
                    ans.get(size - 1)[1] = Math.max(ans.get(size - 1)[1], right);
                }
            }

            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
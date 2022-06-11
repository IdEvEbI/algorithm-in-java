package com.idevebi.datastructures.hash.leetcode.editor.cn;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new MinimumIndexSumOfTwoLists().new Solution();

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] ans = solution.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            // 比较列表长度，以较短的列表构建 Hash 表
            if (list1.length > list2.length) {
                return findRestaurant(list2, list1);
            }

            // 构建 HashMap
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }

            // 扫描 list2
            List<String> ans = new ArrayList<>();
            int minIndexSum = Integer.MAX_VALUE;

            for (int i = 0; i < list2.length; i++) {
                String item = list2[i];
                int j = map.getOrDefault(item, -1);

                if (j == -1) {
                    continue;
                }

                if (i + j < minIndexSum) {
                    ans.clear();
                    ans.add(item);
                    minIndexSum = i + j;
                } else if (i + j == minIndexSum) {
                    ans.add(item);
                }
            }

            return ans.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

        TreeNode n = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(n);

        n = solution.sortedArrayToBST(new int[]{});
        System.out.println(n);

        n = solution.sortedArrayToBST(new int[]{1});
        System.out.println(n);

        n = solution.sortedArrayToBST(new int[]{1, 2});
        System.out.println(n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return arrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode arrayToBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            // 取中间位置左侧的数值
            int mid = (right + left) / 2;
            // 新建节点
            TreeNode n = new TreeNode(nums[mid]);

            // 递归
            n.left = arrayToBST(nums, left, mid - 1);
            n.right = arrayToBST(nums, mid + 1, right);

            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
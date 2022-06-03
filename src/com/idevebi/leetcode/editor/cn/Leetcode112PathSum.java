package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

public class Leetcode112PathSum {
    public static void main(String[] args) {
        Solution solution = new Leetcode112PathSum().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        boolean b = solution.hasPathSum(root, 18);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            // 叶子节点
            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            }

            return hasPathSum(root.left, sum - root.val) ||
                    hasPathSum(root.right, sum - root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
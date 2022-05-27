package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

public class Leetcode104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode104MaximumDepthOfBinaryTree().new Solution();

        int depth = solution.maxDepth(root);
        System.out.println(depth);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
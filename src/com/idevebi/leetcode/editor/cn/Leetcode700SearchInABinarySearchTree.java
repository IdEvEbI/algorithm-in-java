package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

public class Leetcode700SearchInABinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode700SearchInABinarySearchTree().new Solution();

        System.out.println(solution.searchBST(root, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {

            while (root != null) {
                if (root.val == val) {
                    return root;
                }

                root = (root.val > val) ? root.left : root.right;
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

/**
 * 700. 二叉搜索树中的搜索
 */
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.searchBST(root, 3).val);
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
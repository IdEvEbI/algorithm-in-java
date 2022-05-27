package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

public class Leetcode101SymmetricTree {

    public static void main(String[] args) {

        Solution solution = new Leetcode101SymmetricTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.isSymmetric(root));

        root = TreeHelper.createMirrorTree();
        System.out.println(solution.isSymmetric(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        /**
         * 子树对称条件
         * <p>
         * 1. 根节点的左右两个子节点具有相同的值
         * 2. 根节点的左子树与右子树镜像对称
         */
        private boolean check(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {
                return true;
            }
            if (n1 == null || n2 == null) {
                return false;
            }

            return (n1.val == n2.val) && check(n1.left, n2.right) && check(n1.right, n2.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
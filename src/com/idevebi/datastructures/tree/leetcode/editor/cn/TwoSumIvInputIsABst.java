package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.findTarget(root, 11));
        System.out.println(solution.findTarget(root, 28));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private Set<Integer> set = new HashSet();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }

            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);

            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.isValidBST(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用递归验证二叉搜索树
         */
        public boolean isValidBST(TreeNode root) {
            // return validBST(root);
            return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        /**
         * 方法 2：递归
         */
        private boolean valid(TreeNode root, long minValue, long maxValue) {
            if (root == null) {
                return true;
            }
            if (root.val <= minValue || root.val >= maxValue) {
                return false;
            }

            // 左子树的所有值都小于 root.val && 右子树的所有值都大于 root.val
            return valid(root.left, minValue, root.val) && valid(root.right, root.val, maxValue);
        }

        /**
         * 方法 1：使用中序遍历验证二叉搜索树
         */
        private boolean validBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            long preVal = Long.MIN_VALUE;

            while (!stack.isEmpty() || root != null) {
                // 遍历到最左侧节点
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                // 如果中序遍历过程中，出现比之前的值小的情况，说明不是二叉搜索树
                if (root.val <= preVal) {
                    return false;
                }

                preVal = root.val;
                root = root.right;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
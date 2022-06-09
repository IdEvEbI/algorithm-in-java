package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.invertTree(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            invertWithRecursion(root);

            return root;
        }

        /**
         * 方法 2：使用递归翻转
         */
        private void invertWithRecursion(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            invertWithRecursion(root.left);
            invertWithRecursion(root.right);
        }

        /**
         * 方法 1：使用 BFS 翻转
         */
        private TreeNode invertWithBFS(TreeNode root) {
            if (root == null) {
                return root;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();

                    TreeNode tmp = n.left;
                    n.left = n.right;
                    n.right = tmp;

                    if (n.left != null) {
                        queue.offer(n.left);
                    }
                    if (n.right != null) {
                        queue.offer(n.right);
                    }
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
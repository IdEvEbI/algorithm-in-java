package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        List<List<Integer>> list = solution.levelOrder(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            return levelOrderWithRecursion(root);
        }

        /**
         * 方法 2：递归实现层序遍历
         */
        private List<List<Integer>> levelOrderWithRecursion(TreeNode root) {
            // 遍历结果
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            levelBFS(root, res, 0);

            return res;
        }

        private void levelBFS(TreeNode root, List<List<Integer>> res, int h) {
            if (root == null) {
                return;
            }
            if (res.size() == h) {
                res.add(new ArrayList<>());
            }

            res.get(h).add(root.val);
            levelBFS(root.left, res, h + 1);
            levelBFS(root.right, res, h + 1);
        }

        /**
         * 方法 1：利用队列迭代遍历
         */
        private List<List<Integer>> levelOrderWithBFS(TreeNode root) {
            // 遍历结果
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> l = new ArrayList<>();
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();

                    l.add(n.val);
                    if (n.left != null) {
                        queue.offer(n.left);
                    }
                    if (n.right != null) {
                        queue.offer(n.right);
                    }
                }
                res.add(l);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
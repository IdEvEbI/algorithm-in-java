package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode102BinaryTreeLevelOrderTraversal().new Solution();

        List<List<Integer>> list = solution.levelOrder(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * 递归遍历
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            // 遍历结果
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            level(root, res, 0);

            return res;
        }

        private void level(TreeNode root, List<List<Integer>> res, int h) {
            if (root == null) {
                return;
            }
            if (res.size() == h) {
                res.add(new ArrayList<>());
            }

            res.get(h).add(root.val);
            level(root.left, res, h + 1);
            level(root.right, res, h + 1);
        }

        /**
         * 利用队列迭代遍历
         */
        public List<List<Integer>> levelOrder2(TreeNode root) {
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
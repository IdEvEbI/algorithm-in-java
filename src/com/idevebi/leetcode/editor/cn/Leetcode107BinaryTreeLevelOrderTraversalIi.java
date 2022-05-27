package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode107BinaryTreeLevelOrderTraversalIi().new Solution();

        List<List<Integer>> list = solution.levelOrderBottom(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 遍历结果
            List<List<Integer>> res = new LinkedList<>();

            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> l = new LinkedList<>();
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
                // 与 102 的唯一区别
                res.add(0, l);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode94BinaryTreeInorderTraversal {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode94BinaryTreeInorderTraversal().new Solution();

        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 使用 stack 实现中序遍历
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 判断根节点
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode n = root;

            while (!stack.isEmpty() || n != null) {
                // 左
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
                // 根
                n = stack.pop();
                res.add(n.val);
                // 右
                n = n.right;
            }

            return res;
        }

        /**
         * 使用递归实现中序遍历
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 中序遍历
            inorder(root, res);

            return res;
        }

        private void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            // 左
            inorder(root.left, res);
            // 根
            res.add(root.val);
            // 右
            inorder(root.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

import java.util.ArrayList;
import java.util.List;

public class Leetcode144BinaryTreePreorderTraversal {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode144BinaryTreePreorderTraversal().new Solution();

        List<Integer> list = solution.preorderTraversal(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 前序调用
            preorder(root, res);

            return res;
        }

        private void preorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            // 根
            res.add(root.val);
            // 左
            preorder(root.left, res);
            // 右
            preorder(root.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
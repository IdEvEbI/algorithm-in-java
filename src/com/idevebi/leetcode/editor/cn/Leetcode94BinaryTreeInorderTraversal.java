package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

import java.util.ArrayList;
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
        public List<Integer> inorderTraversal(TreeNode root) {
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
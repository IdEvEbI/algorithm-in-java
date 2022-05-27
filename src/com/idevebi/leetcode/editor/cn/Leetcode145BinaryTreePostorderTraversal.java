package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

import java.util.ArrayList;
import java.util.List;

public class Leetcode145BinaryTreePostorderTraversal {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode145BinaryTreePostorderTraversal().new Solution();

        List<Integer> list = solution.postorderTraversal(root);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            // 遍历结果
            List<Integer> res = new ArrayList<>();

            // 后序调用
            postorder(root, res);

            return res;
        }

        private void postorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            // 左
            postorder(root.left, res);
            // 右
            postorder(root.right, res);
            // 根
            res.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
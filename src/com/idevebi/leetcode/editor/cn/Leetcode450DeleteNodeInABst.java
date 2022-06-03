package com.idevebi.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

/**
 * 参考题解：<a href="https://leetcode.cn/problems/delete-node-in-a-bst/solution/miao-dong-jiu-wan-shi-liao-by-terry2020-tc0o/">https://leetcode.cn/problems/delete-node-in-a-bst/solution/miao-dong-jiu-wan-shi-liao-by-terry2020-tc0o/</a>
 */
public class Leetcode450DeleteNodeInABst {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        Solution solution = new Leetcode450DeleteNodeInABst().new Solution();

        root = solution.deleteNode(root, 5);
        System.out.println(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            // 如果 root.val == key，处理删除节点
            if (root.val == key) {
                // 1. 如果左节点为空
                if (root.left == null) {
                    return root.right;
                }
                // 2. 如果右节点为空
                if (root.right == null) {
                    return root.left;
                }

                // 找到右子树最左侧的节点
                TreeNode n = root.right;
                while (n.left != null) {
                    n = n.left;
                }

                // 用右子节点替代原有位置
                n.left = root.left;
                root = root.right;
            } else if (key > root.val) {
                // 递归调用，去右子树查找节点
                root.right = deleteNode(root.right, key);
            } else {
                // 递归调用，去左子树查找节点
                root.left = deleteNode(root.left, key);
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
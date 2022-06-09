package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();

        TreeNode root = TreeHelper.createTestTree();
        System.out.println(solution.insertIntoBST(root, 2));

        // 测试连续插入 1~5 观察二叉树退化成链表
        root = solution.insertIntoBST(null, 1);
        for (int i = 2; i < 6; i++) {
            solution.insertIntoBST(root, i);
        }
        System.out.println("二叉树退化");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // 新建节点
            TreeNode n = new TreeNode(val);

            // 如果 root 为 null，直接创建节点
            if (root == null) {
                return n;
            }

            // 遍历节点
            TreeNode cur = root;
            while (cur != null) {
                // 如果 val 比 cur.val 小，查找左侧节点
                if (val < cur.val) {
                    // 如果左侧叶子节点为空，直接添加节点
                    if (cur.left == null) {
                        cur.left = n;
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = n;
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }

            // 返回根节点
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
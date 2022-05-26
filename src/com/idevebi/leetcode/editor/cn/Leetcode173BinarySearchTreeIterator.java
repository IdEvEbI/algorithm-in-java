package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode173BinarySearchTreeIterator {
    public static void main(String[] args) {

        /*
         *                5
         *             3     7
         *           1   4  6  9
         */
        // 创建二叉树
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        BSTIterator bst = new Leetcode173BinarySearchTreeIterator().new BSTIterator(root);

        while (bst.hasNext()) {
            System.out.println(bst.next());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class BSTIterator {

        // 当前节点
        private TreeNode cur;
        // 节点栈
        private final Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.cur = root;
            this.stack = new ArrayDeque<>();
        }

        public int next() {
            // 迭代到最左侧节点，并顺序压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 弹出最底层左节点
            cur = stack.pop();
            int res = cur.val;

            cur = cur.right;

            return res;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
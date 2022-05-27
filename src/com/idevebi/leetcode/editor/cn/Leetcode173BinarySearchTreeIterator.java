package com.idevebi.leetcode.editor.cn;

import com.idevebi.leetcode.editor.cn.datastructures.tree.TreeNode;
import com.idevebi.leetcode.editor.cn.util.TreeHelper;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode173BinarySearchTreeIterator {
    public static void main(String[] args) {

        TreeNode root = TreeHelper.createTestTree();

        BSTIterator bst = new Leetcode173BinarySearchTreeIterator().new BSTIterator(root);

        while (bst.hasNext()) {
            System.out.println(bst.next());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class BSTIterator {

        // 节点栈
        private final Deque<TreeNode> stack;
        // 当前节点
        private TreeNode cur;

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
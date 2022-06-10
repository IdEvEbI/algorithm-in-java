package com.idevebi.datastructures.tree.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeIi my = new PopulatingNextRightPointersInEachNodeIi();

        Solution solution = my.new Solution();

        // 构建二叉树
        Node root = my.new Node(1);

        root.left = my.new Node(2);
        root.left.left = my.new Node(4);
        root.left.right = my.new Node(5);

        root.right = my.new Node(3);
        root.right.right = my.new Node(7);

        // 填充 next 指针
        solution.connect(root);
        System.out.println(root);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public Node connect(Node root) {
            return connectWithLeftMost(root);
        }

        /**
         * 方法 2：使用最左侧节点连接（不使用 队列）
         */
        private Node connectWithLeftMost(Node root) {
            if (root == null) {
                return null;
            }

            // 从 根节点 开始遍历
            Node start = root;

            while (start != null) {
                // 下一个起始节点
                Node nextStart = null;
                // 前一个节点
                Node pre = null;

                // 使用 next 指针逐层遍历
                for (Node p = start; p != null; p = p.next) {
                    if (p.left != null) {
                        if (pre != null) {
                            pre.next = p.left;
                        }
                        if (nextStart == null) {
                            nextStart = p.left;
                        }
                        pre = p.left;
                    }
                    if (p.right != null) {
                        if (pre != null) {
                            pre.next = p.right;
                        }
                        if (nextStart == null) {
                            nextStart = p.right;
                        }
                        pre = p.right;
                    }
                }
                start = nextStart;
            }

            return root;
        }

        /**
         * 方法 1：使用 BFS 连接右节点
         */
        private Node connectWithBFS(Node root) {
            if (root == null) {
                return null;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            // BFS
            while (!queue.isEmpty()) {
                int size = queue.size();

                // 扫描当前层的所有节点
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node n = queue.poll();

                    if (n.left != null) {
                        queue.offer(n.left);
                    }
                    if (n.right != null) {
                        queue.offer(n.right);
                    }

                    // 前一个节点的 next 连接当前节点
                    if (i != 0) {
                        pre.next = n;
                    }

                    pre = n;
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
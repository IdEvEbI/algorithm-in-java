package com.idevebi.datastructures.tree.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode my = new PopulatingNextRightPointersInEachNode();

        Solution solution = my.new Solution();

        // 构建完美二叉树
        Node root = my.new Node(1);

        root.left = my.new Node(2);
        root.left.left = my.new Node(4);
        root.left.right = my.new Node(5);

        root.right = my.new Node(3);
        root.right.left = my.new Node(6);
        root.right.right = my.new Node(7);

        // 填充 next 指针，next 指向 null
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
         * <p>
         * 思路：
         * 1. 根节点 的 left 是 最左节点
         * 2. 最左节点 的 left 依旧是 最左节点
         * ……
         */
        private Node connectWithLeftMost(Node root) {
            if (root == null) {
                return null;
            }

            // 根节点就是 最左节点
            Node leftMost = root;

            while (leftMost.left != null) {

                // 遍历 leftMost 所在的一层节点（下一层的 next 已经构建好）
                Node head = leftMost;

                while (head != null) {
                    // 情况 1：head 有 左右儿子
                    head.left.next = head.right;

                    // 情况 2：head 有 next
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }

                    // 向右移动 head
                    head = head.next;
                }

                // 遍历下一层
                leftMost = leftMost.left;
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
            // 根节点入队
            queue.offer(root);

            // BFS
            while (!queue.isEmpty()) {
                int size = queue.size();

                // 扫描当前层的所有节点
                for (int i = 0; i < size; i++) {
                    Node n = queue.poll();

                    // 连接
                    if (i < size - 1) {
                        n.next = queue.peek();
                    }

                    // 下一层节点入队（完美二叉树只需要判断左节点）
                    if (n.left != null) {
                        queue.offer(n.left);
                        queue.offer(n.right);
                    }
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
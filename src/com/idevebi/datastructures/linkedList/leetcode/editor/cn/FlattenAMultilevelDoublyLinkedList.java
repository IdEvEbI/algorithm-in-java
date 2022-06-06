package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

/**
 * 430. 扁平化多级双向链表
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        FlattenAMultilevelDoublyLinkedList my = new FlattenAMultilevelDoublyLinkedList();

        Solution solution = my.new Solution();

        // 创建链表
        Node head = my.new Node(1);
        head.child = my.new Node(3);
        head.next = my.new Node(2);
        head.next.prev = head;

        head = solution.flatten(head);
        System.out.println(head.val);
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node flatten(Node head) {
            return flattenWithIterate(head);
        }

        /**
         * 方法 2：迭代法
         */
        private Node flattenWithIterate(Node head) {
            if (head == null) {
                return head;
            }

            Node n = head;
            // 扫描链表
            while (n != null) {
                if (n.child == null) {
                    n = n.next;
                } else {
                    // 子节点的头节点
                    Node child = n.child;
                    // 遍历到下一层的末尾
                    while (child.next != null) {
                        child = child.next;
                    }

                    // 拼接链表
                    child.next = n.next;
                    if (n.next != null) {
                        n.next.prev = child;
                    }

                    n.next = n.child;
                    n.next.prev = n;
                    n.child = null;
                }
            }

            return head;
        }

        /**
         * 方法 1：递归调用
         */
        private Node flattenWithRecursion(Node head) {
            // 哨兵节点
            Node n = new Node();
            n.next = head;

            // 深度优先扫描
            while (head != null) {
                if (head.child == null) {
                    head = head.next;
                } else {
                    // 先记住下一节点
                    Node next = head.next;

                    // 递归获得子节点的扁平化链表
                    Node childHead = flatten(head.child);

                    // 拼接链表
                    head.next = childHead;
                    childHead.prev = head;
                    head.child = null;

                    // 遍历到子链表的尾部，继续拼接
                    while (head.next != null) {
                        head = head.next;
                    }

                    head.next = next;
                    if (next != null) {
                        next.prev = head;
                    }

                    // 继续遍历后续节点
                    head = next;
                }
            }

            return n.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
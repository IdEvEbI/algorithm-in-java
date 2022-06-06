package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

/**
 * 707. 设计链表
 */
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new DesignLinkedList().new MyLinkedList();

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class ListNode {
        int val;

        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {
        /**
         * 链表长度
         */
        int size;
        /**
         * 头节点，哨兵节点（伪头）
         */
        ListNode head;
        /**
         * 尾节点，哨兵节点（伪尾）
         */
        ListNode tail;

        /**
         * 构造器
         */
        public MyLinkedList() {
            head = new ListNode(Integer.MAX_VALUE);
            tail = new ListNode(Integer.MIN_VALUE);

            head.next = tail;
            tail.prev = head;
        }

        /**
         * 获取链表中第 index 个节点的值。如果索引无效，则返回 -1
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            // 根据 index 决定从前还是从后遍历链表
            ListNode n = head.next;
            if (index < size - index) {
                for (int i = 0; i < index; i++) {
                    n = n.next;
                }
            } else {
                n = tail;
                for (int i = 0; i < size - index; i++) {
                    n = n.prev;
                }
            }

            return n.val;
        }

        /**
         * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
         */
        public void addAtHead(int val) {
            ListNode n = new ListNode(val);

            n.next = head.next;
            n.prev = head;

            head.next.prev = n;
            head.next = n;

            size++;
        }

        /**
         * 将值为 val 的节点追加到链表的最后一个元素
         */
        public void addAtTail(int val) {
            ListNode n = new ListNode(val);

            n.next = tail;
            n.prev = tail.prev;

            tail.prev.next = n;
            tail.prev = n;

            size++;
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点
         * <p>
         * - 如果 index 等于链表的长度，则该节点将附加到链表的末尾
         * - 如果 index 大于链表长度，则不会插入节点
         * - 如果 index 小于 0，则在头部插入节点
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            index = Math.max(index, 0);

            // 遍历链表到 index 位置的 前、后 节点
            ListNode pNode, nNode;

            if (index < size - index) {
                pNode = head;
                for (int i = 0; i < index; i++) {
                    pNode = pNode.next;
                }
                nNode = pNode.next;
            } else {
                nNode = tail;
                for (int i = 0; i < size - index; i++) {
                    nNode = nNode.prev;
                }
                pNode = nNode.prev;
            }

            // 添加节点
            ListNode n = new ListNode(val);

            n.prev = pNode;
            n.next = nNode;

            pNode.next = n;
            nNode.prev = n;

            size++;
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            ListNode n = head.next;
            if (index < size - index) {
                for (int i = 0; i < index; i++) {
                    n = n.next;
                }
            } else {
                n = tail;
                for (int i = 0; i < size - index; i++) {
                    n = n.prev;
                }
            }

            n.prev.next = n.next;
            n.next.prev = n.prev;

            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
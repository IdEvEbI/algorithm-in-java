package com.idevebi.datastructures.hash.leetcode.editor.cn;

/**
 * 705. 设计哈希集合
 */
public class DesignHashset {
    public static void main(String[] args) {
        DesignHashset.MyHashSet myHashSet = new DesignHashset().new MyHashSet();

        testHash();

        myHashSet.add(1);
        myHashSet.add(1);
        myHashSet.add(886);
        myHashSet.add(1771);

        // myHashSet.remove(2);
        // myHashSet.remove(886);
        // myHashSet.remove(1);
        // myHashSet.remove(1771);

        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(2));
        System.out.println(myHashSet.contains(886));

        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));

        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

    /**
     * 测试哈希函数
     * <p>
     * 目标：100000 个数字，大体均匀地分布在 1000 个桶中
     */
    private static void testHash() {
        int count = 100001;
        int len = 801;

        // 计算 800 ~ 900 之间保存 100001 个数字，每个桶装的尽可能满
        int min = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 801; i <= 900; i++) {
            int n = count - (count / i) * i;

            if (n > min) {
                min = n;
                idx = i;
            }
        }

        System.out.println(idx + " - " + min);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        // 题目规则，最多只有 0 <= key <= 10^6
        // 100001 个数字保存在 885 个桶中，每个链表长度几乎都是 113
        private final int BUCKET_SIZE = 885;
        Node[] list;

        public MyHashSet() {
            list = new Node[BUCKET_SIZE];
        }

        public void add(int key) {
            int h = hash(key);

            // 判断链表 头节点 是否已经存在
            Node head = list[h];

            // 如果 头节点 不存在，新建节点并返回
            if (head == null) {
                head = new Node(key);
                list[h] = head;

                return;
            }

            Node cur = head;
            // 遍历链表，检查 key 是否已经存在
            while (cur != null) {
                if (cur.val == key) {
                    return;
                }
                cur = cur.next;
            }

            // 遍历到链表末尾 cur == null，说明还没有记录 key
            Node keyNode = new Node(key);
            keyNode.next = head.next;
            head.next = keyNode;
        }

        public void remove(int key) {
            int h = hash(key);

            Node head = list[h];

            // 如果 头节点 不存在，直接返回
            if (head == null) {
                return;
            }

            // 如果头节点保存的就是 key 值，直接删除头节点
            if (head.val == key) {
                list[h] = head.next;
                return;
            }

            // 遍历链表，查找并删除 key 所在的节点
            while (head.next != null) {
                if (head.next.val == key) {
                    head.next = head.next.next;
                    return;
                }

                head = head.next;
            }
        }

        public boolean contains(int key) {
            int h = hash(key);

            Node head = list[h];

            if (head == null) {
                return false;
            }

            while (head != null) {
                if (head.val == key) {
                    return true;
                }

                head = head.next;
            }

            return false;
        }

        int hash(int key) {
            return key % BUCKET_SIZE;
        }

        /**
         * 链表节点
         */
        private static class Node {
            private final int val;
            private Node next;

            private Node(int _val) {
                val = _val;
            }
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
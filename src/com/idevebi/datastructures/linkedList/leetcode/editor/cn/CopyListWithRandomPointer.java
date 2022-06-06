package com.idevebi.datastructures.linkedList.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/copy-list-with-random-pointer/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-pqek/">https://leetcode.cn/problems/copy-list-with-random-pointer/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-pqek/</a>
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        CopyListWithRandomPointer my = new CopyListWithRandomPointer();

        Solution solution = my.new Solution();

        Node head = my.new Node(1);
        head.next = my.new Node(2);
        head.random = head.next;
        head.next.random = head.next;

        Node newNode = solution.copyRandomList(head);
        System.out.println(newNode);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node copyRandomList(Node head) {
            // 1. 准备工作
            Map<Node, Node> map = new HashMap<>();
            Node dummy = new Node(999);

            Node newList = dummy;
            Node cur = head;

            // 2. 遍历链表，填充 HashMap
            while (cur != null) {
                Node n = new Node(cur.val);

                map.put(cur, n);

                newList.next = n;
                newList = newList.next;

                cur = cur.next;
            }

            // 3. 再次遍历链表，设置 random 指针
            newList = dummy.next;
            while (head != null) {
                if (head.random != null) {
                    newList.random = map.get(head.random);
                }

                newList = newList.next;
                head = head.next;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
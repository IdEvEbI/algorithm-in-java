package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.Node;
import com.idevebi.datastructures.util.NTreeHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 428. 序列化和反序列化 N 叉树
 */
public class SerializeAndDeserializeNAryTree {
    public static void main(String[] args) {
        Codec coder = new SerializeAndDeserializeNAryTree().new Codec();

        // 1. 测试 1
        Node root = NTreeHelper.createTestNTree();

        String ans = coder.serialize(root);
        System.out.println(ans);

        Node n = coder.deserialize(ans);
        System.out.println(n);

        // 2. 测试 2
        ans = coder.serialize(null);
        System.out.println(ans);

        n = coder.deserialize(ans);
        System.out.println(n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Codec {
        private final String NULL = "x";
        private final String SEP = ",";

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return NULL;
            }

            StringBuilder sb = new StringBuilder();
            serialize(root, sb);

            return sb.toString();
        }

        public void serialize(Node root, StringBuilder sb) {
            int size = (root.children == null ? 0 : root.children.size());

            sb.append(root.val).append(SEP).append(size).append(SEP);

            if (root.children != null) {
                for (Node c : root.children) {
                    serialize(c, sb);
                }
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data == null) {
                return null;
            }

            LinkedList<String> list = new LinkedList<>();
            Collections.addAll(list, data.split(SEP));

            return deserialize(list);
        }

        private Node deserialize(LinkedList<String> list) {
            // System.out.println(list);
            if (list.size() == 0) {
                return null;
            }

            String s = list.removeFirst();
            if (s.equals(NULL)) {
                return null;
            }
            Node root = new Node(Integer.parseInt(s));

            int size = Integer.parseInt(list.removeFirst());

            root.children = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root.children.add(deserialize(list));
            }

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
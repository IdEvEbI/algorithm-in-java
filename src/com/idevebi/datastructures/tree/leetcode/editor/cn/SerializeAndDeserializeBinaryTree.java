package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.TreeNode;
import com.idevebi.datastructures.util.TreeHelper;

import java.util.Collections;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBinaryTree().new Codec();

        TreeNode root = TreeHelper.createTestTree();

        String str = codec.serialize(root);
        System.out.println(str);

        TreeNode n = codec.deserialize(str);
        System.out.println(n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Codec {
        private final String NULL = "x";
        private final String SEP = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            serialize(root, sb);

            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>();
            Collections.addAll(list, data.split(SEP));

            return deserialize(list);
        }

        private TreeNode deserialize(LinkedList<String> list) {
            String s = list.removeFirst();

            if (s.equals(NULL)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(list);
            root.right = deserialize(list);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
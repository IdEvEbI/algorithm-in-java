package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.Node;
import com.idevebi.datastructures.util.NTreeHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 */
public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();

        Node root = NTreeHelper.createTestNTree();

        System.out.println(solution.levelOrder(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                // 完成一层的遍历
                List<Integer> level = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node n = queue.poll();

                    level.add(n.val);

                    if (n.children != null) {
                        for (Node c : n.children) {
                            queue.offer(c);
                        }
                    }
                }

                ans.add(level);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
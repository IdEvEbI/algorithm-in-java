package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.Node;
import com.idevebi.datastructures.util.NTreeHelper;

/**
 * 559. N 叉树的最大深度
 */
public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();

        Node root = NTreeHelper.createTestNTree();
        System.out.println(solution.maxDepth(root));

        System.out.println(solution.maxDepth(null));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }

            int depth = 0;

            if (root.children != null) {
                for (Node n : root.children) {
                    depth = Math.max(depth, maxDepth(n));
                }
            }

            return depth + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
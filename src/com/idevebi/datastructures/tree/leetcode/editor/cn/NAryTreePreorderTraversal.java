package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.Node;
import com.idevebi.datastructures.util.NTreeHelper;

import java.util.List;

/**
 * 589. N 叉树的前序遍历
 */
public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();

        Node root = NTreeHelper.createTestNTree();
        System.out.println(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> preorder(Node root) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
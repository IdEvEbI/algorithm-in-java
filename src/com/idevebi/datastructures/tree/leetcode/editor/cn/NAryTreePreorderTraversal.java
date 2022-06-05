package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.Node;
import com.idevebi.datastructures.util.NTreeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 */
public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();

        Node root = NTreeHelper.createTestNTree();
        List<Integer> list = solution.preorder(root);

        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> ans = new ArrayList<>();

            dfs(root, ans);

            return ans;
        }

        private void dfs(Node root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            ans.add(root.val);

            if (root.children == null) {
                return;
            }

            for (Node n : root.children) {
                dfs(n, ans);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
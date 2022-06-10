package com.idevebi.datastructures.tree.leetcode.editor.cn;

import com.idevebi.datastructures.tree.Node;
import com.idevebi.datastructures.util.NTreeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 */
public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();

        Node root = NTreeHelper.createTestNTree();
        List<Integer> list = solution.postorder(root);

        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new ArrayList<>();

            dfs(root, ans);

            return ans;
        }

        private void dfs(Node root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            if (root.children == null) {
                ans.add(root.val);
                return;
            }

            for (Node n : root.children) {
                dfs(n, ans);
            }

            ans.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
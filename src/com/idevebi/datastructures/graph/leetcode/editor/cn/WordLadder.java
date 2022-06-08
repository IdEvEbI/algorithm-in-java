package com.idevebi.datastructures.graph.leetcode.editor.cn;

import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/">https://leetcode.cn/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/</a>
 * <p>
 * 官方题解的思路很巧妙
 */
public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(solution.ladderLength("hit", "cog", wordList));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, Integer> wordId = new HashMap<String, Integer>();
        List<List<Integer>> edge = new ArrayList<List<Integer>>();
        int nodeNum = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            // 1. 构建图（添加顺序是 id，edge 记录节点的边
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);

            // System.out.println(edge);
            // System.out.println(wordId);

            // 如果目标单词不在字典中，直接返回
            if (!wordId.containsKey(endWord)) {
                return 0;
            }

            // 2. 计算距离准备
            int[] dis = new int[nodeNum];
            Arrays.fill(dis, Integer.MAX_VALUE);
            int beginId = wordId.get(beginWord);
            int endId = wordId.get(endWord);

            dis[beginId] = 0;

            // 3. BFS 遍历
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(beginId);

            while (!queue.isEmpty()) {
                int x = queue.poll();
                // 如果找到目标单词
                if (x == endId) {
                    return dis[endId] / 2 + 1;
                }
                // 更新距离，当前单词的距离 + 1
                for (int id : edge.get(x)) {
                    if (dis[id] == Integer.MAX_VALUE) {
                        dis[id] = dis[x] + 1;
                        queue.offer(id);
                    }
                }
            }

            return 0;
        }

        private void addEdge(String word) {
            addWord(word);

            // 单词节点 id
            int id1 = wordId.get(word);
            char[] chars = word.toCharArray();
            int len = chars.length;

            // 扫描单词，把每个子母替换成 '*' 添加到图中，建立对应的边
            for (int i = 0; i < len; i++) {
                char c = chars[i];

                chars[i] = '*';
                String newWord = new String(chars);
                addWord((newWord));

                int id2 = wordId.get(newWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);

                // 恢复单词
                chars[i] = c;
            }
        }

        /**
         * 将单词添加到 HashMap
         * <p>
         * key 是单词
         * value 是添加顺序 idx → 对应 edge 数组中的边
         */
        private void addWord(String word) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, nodeNum++);
                edge.add(new ArrayList<>());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}